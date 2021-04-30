package com.java8.thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadAnalyse {
    /**
     * Exception in thread "main" java.lang.IllegalThreadStateException
     * 	at java.lang.Thread.start(Thread.java:708)
     * 	at com.java8.thread.ThreadAnalyse.main(ThreadAnalyse.java:13)
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger aI = new AtomicInteger(0);
        Thread t = new Thread(()->{
            System.out.println(Thread.currentThread().getId()+ " : " + aI.incrementAndGet());
        });
        t.start();
        t.join();
        Thread.sleep(3000);
        t.start();//同一个线程无法
    }
}
