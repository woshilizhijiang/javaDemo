package mycom.threadpool.lock.reentrantLock.simple;

public class MyThread extends Thread{

    private ReentrantLockDemo01 rld;

    public MyThread(ReentrantLockDemo01 rld){
        this.rld = rld;
    }

    @Override
    public void run() {
        rld.simpleReentrantLock();
    }

    public static void main(String[] args) {
        ReentrantLockDemo01 rld01 = new ReentrantLockDemo01();
        MyThread mt1 = new MyThread(rld01);
        MyThread mt2 = new MyThread(rld01);
        MyThread mt3 = new MyThread(rld01);
        mt1.start();
        mt2.start();
        mt3.start();
    }
}
