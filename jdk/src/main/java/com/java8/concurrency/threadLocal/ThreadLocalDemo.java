package com.java8.concurrency.threadLocal;

import java.text.SimpleDateFormat;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {

    static final ThreadLocal<Integer> tlRandom = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(1);
        }
    };

    static ThreadLocal<Integer> atLocal = ThreadLocal.withInitial(() -> 11);

    static final ThreadLocal<SimpleDateFormat> dateTime = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyyMMddHHmmss");
        }
    };

    private static final AtomicInteger nextId = new AtomicInteger(0);

    private static final ThreadLocal<Integer> threadId = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return nextId.getAndIncrement();
        }
    };

    public static void main(String[] args) {

        AtomicInteger aa = new AtomicInteger();
        int i =  aa.getAndAdd(0x61c88647) & (16 - 1);
        System.out.println(i);

        System.out.println(atLocal.get());
        atLocal.get();
        atLocal.set(12);
        System.out.println(atLocal.get());
        atLocal.remove();
        System.out.println(atLocal.get());


        tlRandom.set(2);
        int a = tlRandom.get();

        System.out.println(nextId);
        threadId.set(5);
        System.out.println(nextId);
        System.out.println(threadId.get());
        System.out.println(nextId);


    }

}
