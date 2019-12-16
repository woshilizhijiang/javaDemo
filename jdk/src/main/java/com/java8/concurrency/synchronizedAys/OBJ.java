package com.java8.concurrency.synchronizedAys;

public class OBJ {

    public OBJ() {
    }

    public static void main(String[] var0) {
        System.out.println("AAAAA");
    }

    public void getPhone() {
        synchronized(this) {
            System.out.println("aa code block");
        }
    }

    public synchronized void getName() {
        System.out.println("aa method");
    }

}
