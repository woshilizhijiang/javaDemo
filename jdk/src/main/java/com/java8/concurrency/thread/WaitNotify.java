package com.java8.concurrency.thread;

public class WaitNotify {

    public static void main(String[] args) throws InterruptedException {
        Object lock = new Object();
        lock.wait();
        lock.notify();
        Thread t1 = new Thread(new WaitClass(lock));
        t1.start();
        Thread t2 = new Thread(new NotifyClass(lock));
        t2.start();
    }

}

class WaitClass implements Runnable{
    private final Object lock;
    WaitClass(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
        try {
            synchronized (lock){
                System.out.println("wait start");
                lock.wait();
                System.out.println("wait end");
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
class NotifyClass implements Runnable{
    private final Object lock;


    NotifyClass(Object lock){
        super();
        this.lock = lock;
    }
    @Override
    public void run() {
            synchronized (lock){
                System.out.println("notify start");
                lock.notify();
                System.out.println("notify end");
            }
    }
}
