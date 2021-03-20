package com.java8.concurrency.concurTool;

import java.util.concurrent.*;

/**
 * 线程信号量
 */
public class SemaphoreTest {

    private static final int THREAD_COUNT = 30;
    private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
    private static Semaphore s = new Semaphore(10);

    public static void main(String[] args) {

        for (int i=0; i <THREAD_COUNT; i++){
            threadPool.execute(()->{
                try {
                    s.acquire();
                    System.out.println(Thread.currentThread().getName() + "save data");
                    TimeUnit.SECONDS.sleep(2);
                    s.release();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }

        threadPool.shutdown();
    }
}
