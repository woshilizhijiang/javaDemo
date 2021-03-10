package mycom.threadpool.lock.reentrantLock.simple;

import org.junit.Test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入互斥锁，具备synchronized方法和语句相同作用，但是功能更强大
 */
public class ReentrantLockDemo01 {

    private Lock lock = new ReentrantLock();

    //最简单重入
    public void simpleReentrantLock(){
        try {
            lock.lock();
            for (int i = 0; i < 1; i++) {
//                System.out.println("ThreadName = " + Thread.currentThread().getName() + " ,i = " + i);
                System.out.println("MethodA begin ThreadName = " + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("MethodA end ThreadName = " + Thread.currentThread().getName());
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
