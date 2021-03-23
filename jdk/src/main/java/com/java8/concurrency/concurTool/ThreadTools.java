package com.java8.concurrency.concurTool;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class ThreadTools {
    public static void main(String[] args) {
//        joinTest();
//        countDownTest();
        cyclicBarrierTest();
    }

    static class A implements Runnable{
        @Override
        public void run() {
            System.out.println(3);
        }
    }

    static CyclicBarrier cb = new CyclicBarrier(2,new A());
    /**
     * 同步屏障
     */
    public static void cyclicBarrierTest(){
        new Thread(() -> {
            try {
                cb.await();
            }catch (Exception e){
                e.printStackTrace();
            }
            System.out.println(1);
        }).start();
        try {
            cb.await();
        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(2);
    }

    static CountDownLatch c = new CountDownLatch(2);
    /**
     * 等待多线程完成
     <pre> {@code
     * class Driver { // ...
     *   void main() throws InterruptedException {
     *     CountDownLatch startSignal = new CountDownLatch(1);
     *     CountDownLatch doneSignal = new CountDownLatch(N);
     *
     *     for (int i = 0; i < N; ++i) // create and start threads
     *       new Thread(new Worker(startSignal, doneSignal)).start();
     *
     *     doSomethingElse();            // don't let run yet
     *     startSignal.countDown();      // let all threads proceed
     *     doSomethingElse();
     *     doneSignal.await();           // wait for all to finish
     *   }
     * }
     */
    public static void countDownTest(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(1);
                c.countDown();
                System.out.println(2);
//                c.countDown();
            }
        }).start();


        try {
//            c.await();
            c.await(5000, TimeUnit.MILLISECONDS);//超时响应
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(3);
    }

    public static void joinTest(){
        Thread parser1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser1 finish");
            }
        });
        Thread parser2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("parser2 finish");
            }
        });
        parser1.start();
        parser2.start();
        try {
            parser1.join();
            parser2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("all parser finish");

    }
}
