package com.java8.concurrency.lockMemory;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    static int a = 0;
    Lock lock = new ReentrantLock();

    public void writer(){
        lock.lock();
        lock.tryLock();
        try {
            a++;
            System.out.println("a:" + a);
//            try {
//                Thread.sleep(50000);
//            }catch (InterruptedException e){
//
//            }

        }finally {
            lock.unlock();
        }
    }

    public void reader(){
        lock.lock();
        try {
            int i = a;
            System.out.println("i:" + i);
//            try {
//                Thread.sleep(50000);
//            }catch (InterruptedException e){
//            }
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockExample example = new ReentrantLockExample();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.writer();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                example.reader();
            }
        });

        t1.start();


//        t2.start();


        System.out.println("dfafdf");

    }
}



