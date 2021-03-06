package com.instance;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;

import java.nio.ByteBuffer;
import java.util.concurrent.*;

public class Producer {

    private final RingBuffer<PCData> ringBuffer;

    public Producer(RingBuffer<PCData> ringBuffer){
        this.ringBuffer = ringBuffer;
    }

    public void pushData(ByteBuffer bb){
        long sequence = ringBuffer.next();
        try {
            PCData event = ringBuffer.get(sequence);
            event.set(bb.getLong(0));
        }finally {
            ringBuffer.publish(sequence);
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int corePoolSize = 2;
        int maxiMumPoolSize = 5;
        int blockQueueSize = 200;
        long keepAliveTime = 0L;

        Executor executor = new ThreadPoolExecutor(
                corePoolSize,
                maxiMumPoolSize,
                keepAliveTime,
                TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue(blockQueueSize),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        PCDataFactory factory = new PCDataFactory();
        int bufferSize = 1024;

        Disruptor<PCData> disruptor = new Disruptor<>(factory,
                bufferSize,
                executor,
                ProducerType.MULTI,
                new BlockingWaitStrategy()
        );

        disruptor.handleEventsWithWorkerPool(
                new Consumer(),
                new Consumer(),
                new Consumer(),
                new Consumer());
        disruptor.start();


        RingBuffer<PCData> ringBuffer = disruptor.getRingBuffer();
        Producer producer = new Producer(ringBuffer);

        ByteBuffer bb = ByteBuffer.allocate(8);

        //这样的for循环很有意思
        for (long l = 0;true;l++){
            bb.putLong(0,1);
            producer.pushData(bb);
            Thread.sleep(100);

            System.out.println("add data " + l);
        }

    }

}
