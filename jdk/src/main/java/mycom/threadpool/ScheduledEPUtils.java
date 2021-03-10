package mycom.threadpool;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledEPUtils {
    public static void main(String[] args) {

        //单线程
        ScheduledExecutorService singlePool = Executors.newSingleThreadScheduledExecutor();
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
//        for (int i = 0; i < 10; i++) {
            Visit visit = new Visit("延迟一次的单线程定时器", 1);
//                pool.schedule(visit,1, TimeUnit.SECONDS);//执行一次
        pool.scheduleAtFixedRate(visit,5,2, TimeUnit.SECONDS);//周期执行
        pool.scheduleWithFixedDelay(visit,5,2,TimeUnit.SECONDS);//周期执行
//        }
    }

   private static class Visit implements Runnable{
        private String name;
        private int index;
        public Visit(String name, int index){
            this.name = name;
            this.index = index;
        }
        @Override
        public void run() {
            String desc = String.format("%s的第%d个任务到此一游", name, index);
            System.out.println(Thread.currentThread().getName() + " 执行为 " + desc);
        }
    }
}
