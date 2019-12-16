package com.java8.concurrency.lockMemory;

import java.util.concurrent.locks.LockSupport;

public class ThreadParkTest {

    public static void main(String[] args) {
        MyThread mt = new MyThread();
        mt.setName("mt");
        mt.start();

        try {
            Thread.currentThread().sleep(10);
                mt.park();
            Thread.currentThread().sleep(10000);
                mt.unPark();
            Thread.currentThread().sleep(10000);
                mt.park();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }


    static class MyThread extends Thread{
        private boolean isPark = false;

        @Override
        public void run() {
            System.out.println(" Enter Thread running......");
            while (true){
                if (isPark){
                    System.out.println( Thread.currentThread().getName() + " Thread is parking......");
                    LockSupport.park();
                }
                System.out.println(Thread.currentThread().getName()+">> is running");
                try {
                    Thread.currentThread().sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

        public void park(){
            isPark = true;
        }

        public void unPark(){
            isPark = false;
            LockSupport.unpark(this);
            System.out.println("Thread is unpark.....");
        }
    }
}
