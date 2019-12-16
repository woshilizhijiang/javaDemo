package com.java8.concurrency.monitorMechanism;

/**
 *
 * 被 synchronized 关键字修饰的方法、代码块，就是 monitor 机制的临界区
 * @author lizhijiang
 */
public class Monitor {

    private Object ANTHER_LOCK = new Object();

    private synchronized void fun1(){}

    private synchronized void fun2(){
    }

    private synchronized void fun3(){
        synchronized (this){}
    }

    private synchronized void fun4(){
        synchronized (ANTHER_LOCK){}
    }

    public static void main(String[] args) {

    }
}
