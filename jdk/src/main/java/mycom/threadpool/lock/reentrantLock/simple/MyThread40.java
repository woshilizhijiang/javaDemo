package mycom.threadpool.lock.reentrantLock.simple;

public class MyThread40 extends Thread {
    private ReentrantConditionDemo01 td;

    public MyThread40(ReentrantConditionDemo01 td){
        this.td = td;
    }

    public void run(){
        td.await();
    }

    public static void main(String[] args) throws InterruptedException{
        ReentrantConditionDemo01 rcd = new ReentrantConditionDemo01();
        MyThread40 myThread40 = new MyThread40(rcd);
        myThread40.start();
        Thread.sleep(2000);
        rcd.signal();

    }
}
