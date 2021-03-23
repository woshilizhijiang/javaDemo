package com.java8.concurrency.concurTool;

import java.util.concurrent.*;

public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<>();
//    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    private static ExecutorService threadPool = new ThreadPoolExecutor(
            2,
            2,
            0L,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        threadPool.execute(()-> {
            try {
                String A = "银行流水A";
                exgr.exchange(A);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        threadPool.execute(()->{
            try {
                String B = "银行流水B";
                String A = exgr.exchange("B");
                System.out.println("A==B : " + A.equals(B) + " , A " + A + ", B " + B);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        });

        threadPool.shutdown();
    }
}
