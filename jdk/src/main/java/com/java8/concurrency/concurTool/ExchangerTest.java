package com.java8.concurrency.concurTool;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExchangerTest {

    private static final Exchanger<String> exgr = new Exchanger<String>();
    private static ExecutorService threadPool = Executors.newFixedThreadPool(2);

    public static void main(String[] args) {
        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String A = "银行流水A";
                    exgr.exchange(A);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });

        threadPool.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    String B = "银行流水B";
                    String A = exgr.exchange("B");
                    System.out.println("A==B : " + A.equals(B) + " , A " + A + ", B " + B);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        });
        threadPool.shutdown();

    }
}