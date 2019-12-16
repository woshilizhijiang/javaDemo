package com.java8.concurrency.utils;

public class FinalExample {

    int i;
    final int j;
    static FinalExample obj;

    public FinalExample(){
        i = 1;
        j = 2;
    }

    public static void writer(){
        obj = new FinalExample();
    }

    public static void reader(){
        FinalExample object = obj;
        int a = object.i;
        int b = object.j;
    }


    public static void main(String[] args) {
        System.out.println("f");
    }
}
