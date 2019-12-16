package com.java8.concurrency.volatileAys;

public class VolatileAlys {
    private volatile  int volatileAlys = 0;

    public static void main(String[] args){
        VolatileAlys aa = new VolatileAlys();

        for (int i=0; i < 10000;i++){
            new Thread(
                () -> System.out.println(
                            Thread.currentThread().getName() + " : " + ++aa.volatileAlys)
            ).start();
        }
    }

}
