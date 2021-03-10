package mycom.stream;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by 20013649 on 2020/6/28.
 */
public class StreamForkJoin {
    public static void main(String[] args){
        List<Integer> list = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 2, 3, 4, 5, 6, 7, 8, 11, 22, 3, 3, 33, 4, 4, 44, 55, 444)
                .parallel()
                .filter(num -> {
                    System.out.println("当前线程：" + Thread.currentThread().getName());
                    return num > 3;
                })
                .collect(Collectors.toList());
        System.out.println(list);


        Instant start = Instant.now();
        ForkJoinPool pool = new ForkJoinPool();
        ForkJoinTask<Long> task = new ForkJoinSumCalculate(0L,50000000L);
        Long sum = pool.invoke(task);
        System.out.println(sum);
        Instant end = Instant.now();
        System.out.println("耗费时间为：" + Duration.between(start, end).toMillis());

    }
}

class ForkJoinSumCalculate extends RecursiveTask<Long> {
    private long start;
    private long end;

    private static final long THURSHOLD = 10000L;  //临界值

    public ForkJoinSumCalculate(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long length = end - start;
        if(length <= THURSHOLD){
            long sum = 0L;

            for (long i = start; i <= end; i++) {
                sum += i;
            }

            return sum;
        }else{
            long middle = (start + end) / 2;

            ForkJoinSumCalculate left = new ForkJoinSumCalculate(start, middle);
            left.fork(); //进行拆分，同时压入线程队列

            ForkJoinSumCalculate right = new ForkJoinSumCalculate(middle+1, end);
            right.fork(); //

            return left.join() + right.join();
        }
    }
}