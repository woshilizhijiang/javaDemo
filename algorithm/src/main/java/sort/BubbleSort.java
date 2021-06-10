package sort;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Bubble sort
 * 时间复杂度O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        int[] array = new int[]{5,8,6,3,9,2,1,7};

        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    atomicInteger.incrementAndGet();
                    isSorted=false;
                }
            }
            if (isSorted){
                break;
            }
        }
        System.out.println("执行次数： " + atomicInteger.get());
        System.out.println(Arrays.toString(array));
    }
}
