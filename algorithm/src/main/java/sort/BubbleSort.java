package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * Bubble sort
 * 时间复杂度O(n2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,1,2,7};
        //传统冒泡排序
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                int temp = 0;
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }

    /**
     * 鸡尾酒排序即为双向冒泡排序
     */
    @Test
    public void doubleBubbleSorted(){
        int[] array = new int[]{5,8,6,3,9,1,2,7};
        int temp = 0;
        for (int i = 0; i < array.length/2; i++) {
            //正序
            for (int j = i; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
            //反序
            for (int j = array.length-i-1;j > i;j--){
                if (array[j] < array[j-1]){
                    temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(array));
    }
}
