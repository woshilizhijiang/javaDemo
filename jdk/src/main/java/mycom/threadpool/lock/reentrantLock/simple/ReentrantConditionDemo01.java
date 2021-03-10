package mycom.threadpool.lock.reentrantLock.simple;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantConditionDemo01 {
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void await(){
        try {
            lock.lock();
            System.out.println("await时间为：" + System.currentTimeMillis());
            condition.await();
            System.out.println("await等待结束");
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void signal(){
        try {
            lock.lock();
            System.out.println("signal时间为：" + System.currentTimeMillis());
            condition.signal();
        }finally {
            lock.unlock();
        }
    }
}
