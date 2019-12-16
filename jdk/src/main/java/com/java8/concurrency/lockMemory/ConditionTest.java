package com.java8.concurrency.lockMemory;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * java.util.concurrent.locks.Condition结合
 * java.util.concurrent.locks.Lock使用
 *
 * 类似效果
 *
 * java.lang.Object的wait notify notifyall必须结合同步锁synchronized(obj){}使用
 */
public class ConditionTest {

    private  volatile  int aa = 18;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public void conditionWait() throws InterruptedException{
        lock.lock();
        try {
            condition.await();
        }finally {
            lock.unlock();
        }
    }

    public void conditionSignal() throws InterruptedException{
        lock.lock();
        try {
            condition.signal();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {

    }
}
