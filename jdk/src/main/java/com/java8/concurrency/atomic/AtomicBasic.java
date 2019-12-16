package com.java8.concurrency.atomic;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;
import java.util.concurrent.atomic.AtomicReference;

public class AtomicBasic {

    static AtomicInteger ai = new AtomicInteger(1);
    static AtomicBoolean ab = new AtomicBoolean();

    static int[] value = new int[]{1,2};
    static AtomicIntegerArray aia = new AtomicIntegerArray(value);

    public static AtomicReference<User> atomicUserRef = new AtomicReference<User>();

    public static void main(String[] args) {
        //AtomicReference测试
//        User user = new User("conan", 15);
//        atomicUserRef.set(user);
//        System.out.println(atomicUserRef.get().getName());
//        System.out.println(atomicUserRef.get().getOld());
//
//        System.out.println("*********************************************************");
//
//        User updateUser = new User("Shinichi", 17);
//        atomicUserRef.compareAndSet(user, updateUser);
//        System.out.println(atomicUserRef.get().getName());
//        System.out.println(atomicUserRef.get().getOld());

        //AtomicIntegerArray测试
//        aia.getAndSet(0,3);
//        System.out.println(aia.get(0));
//        System.out.println(value[0]);//AtomicIntegerArray克隆数组，原来数组不变

        //AtomicInteger测试
//        System.out.println(ai.getAndIncrement());
//        System.out.println(ai.getAndSet(10));
//        System.out.println(ai.get());
//        System.out.println(ai.addAndGet(2));
//        System.out.println(ai.getAndAdd(1));

        //AtomicBoolean测试
//        System.out.println(ab.get());
//        ab.set(true);
//        System.out.println(ab.get());
    }

    static class User{
        private String name;
        private int old;

        public User(String name, int old){
            this.name = name;
            this.old = old;
        }

        public String getName() {
            return name;
        }
        public int getOld() {
            return old;
        }
    }
}
