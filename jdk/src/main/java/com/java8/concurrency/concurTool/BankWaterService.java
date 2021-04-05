package com.java8.concurrency.concurTool;

import java.util.Map;
import java.util.concurrent.*;

public class BankWaterService implements Runnable {

    private CyclicBarrier cyclicBarrier =  new CyclicBarrier(4, this);

    private int corePoolSize = 2;

    private int maximumPoolSize = 2;

    private int keepAliveTime = 0;

    private Executor executor = new ThreadPoolExecutor(
            corePoolSize,
            maximumPoolSize,
            keepAliveTime,
            TimeUnit.MILLISECONDS,
            new LinkedBlockingQueue<>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    private ConcurrentHashMap<String,Integer> sheetBankWaterCount = new ConcurrentHashMap<>();

    private void count(){
        for (int i = 0;i < 4; i++){
            executor.execute(() -> {
                sheetBankWaterCount.put(Thread.currentThread().getName(), 1);
                try {
                    cyclicBarrier.await();
                    System.out.println(cyclicBarrier.getNumberWaiting());
                    System.out.println(cyclicBarrier.isBroken());
                }catch (InterruptedException | BrokenBarrierException e){
                    e.printStackTrace();
                }
            });
        }
    }

    @Override
    public void run() {
        int result = 0;
        for (Map.Entry<String, Integer> sheet  : sheetBankWaterCount.entrySet()){
            result += sheet.getValue();
        }
        sheetBankWaterCount.put("result", result);
        System.out.println(result);
    }

    public static void main(String[] args) {
        BankWaterService bankWaterService = new BankWaterService();
        bankWaterService.count();
    }
}
