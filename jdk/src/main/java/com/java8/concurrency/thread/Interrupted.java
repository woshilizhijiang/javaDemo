package com.java8.concurrency.thread;

import java.util.concurrent.TimeUnit;

public class Interrupted {
    public static void main(String[] args) throws InterruptedException {

        Thread sleepThread = new Thread(new SleepRunner(),"SleepThread");
        sleepThread.setDaemon(true);

        Thread busyThread = new Thread(new BusyRunner(),"BusyThread");
        busyThread.setDaemon(true);

        sleepThread.start();
        busyThread.start();

        TimeUnit.SECONDS.sleep(5);

        sleepThread.interrupt();
        busyThread.interrupt();

        System.out.println("sleep : " +  sleepThread.isInterrupted());
        System.out.println("busy : " +  busyThread.isInterrupted());


        TimeUnit.SECONDS.sleep(2);
    }

    static class SleepRunner implements Runnable{

        @Override
        public void run() {
            while (true){
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class BusyRunner implements Runnable{

        @Override
        public void run() {
            while (true){

            }
        }
    }
}
