package mycom.threadpool.lock.reentrantLock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedBuffer {
    final Lock lock = new ReentrantLock();
    final Condition notFull = lock.newCondition();//写
    final Condition notEmpty = lock.newCondition();//读

    final Object[] items = new Object[100];//缓存队列
    int putptr,takeptr,count  ;//写索引、读索引、队列中存在的数据个数

    public void put(Object x) throws InterruptedException {
        lock.lock();
        try{
            while (count == items.length){//如果队列满了
                notFull.await();
                items[putptr]=x;//赋值
                if (++putptr == items.length){//如果写索引写到队列的最后一个位置了，那么置为0
                    putptr = 0;
                }
                ++count;
                notEmpty.signal();//唤醒读线程
            }
        }finally {
            lock.unlock();
        }
    }
    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while (count == 0)//如果队列为空
                notEmpty.await();//阻塞读线程
            Object x = items[takeptr];//取值
            if (++takeptr == items.length) takeptr = 0;//如果读索引读到队列的最后一个位置了，那么置为0
            --count;//个数--
            notFull.signal();//唤醒写线程
            return x;
        } finally {
            lock.unlock();
        }
    }
}
