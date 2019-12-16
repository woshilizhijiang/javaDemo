package com.java8.concurrency.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class CountTask extends RecursiveTask<Integer> {

    private static final int THRESHOLD = 2;
    private int start;
    private int end;

    public CountTask(int start, int end){
        this.start = start;
        this.end = end;
    }


    @Override
    protected Integer compute() {
        int sum = 0;
        boolean canCompute = (end - start) <= THRESHOLD;
        if (canCompute){
            for (int i = start; i <= end ; i++){
                sum += i;
            }
        }else {
            int middle = (start + end) / 2;
            CountTask leftTask = new CountTask(start,middle);
            CountTask rightTask = new CountTask(middle + 1,end);
            leftTask.fork();
            rightTask.fork();
            int leftRs = leftTask.join();
            int rightRs = rightTask.join();
            sum = leftRs + rightRs;
        }
        return sum;
    }

    public static void main(String[] args) throws Exception {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask task = new CountTask(1,4);
        Future<Integer> result = forkJoinPool.submit(task);
        System.out.println(result.get());

    }
}
