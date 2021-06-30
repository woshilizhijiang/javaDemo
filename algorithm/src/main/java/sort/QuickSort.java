package sort;

import java.util.Arrays;

/**
 * quick sort
 *
 * 时间复杂度：O(nlogn)
 * 分治法的味道：把数据分为两部分
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{5,8,6,3,9,2,1,7};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int startIndex, int endIndex){
        if (startIndex > endIndex) return;
        //得到基准元素位置
        int pivotIndex = partition2(array,startIndex,endIndex);
        quickSort(array,startIndex,pivotIndex-1);
        quickSort(array,pivotIndex+1,endIndex);
    }

    private static int partition(int[] array, int startIndex, int endIndex){
        //取第一个位置的元素作为基准元素
        int pivot = array[startIndex];
        int left = startIndex;
        int right = endIndex;
        while (left != right){
            //控制right 指针比较并左移
            while (left < right && array[right] > pivot){
                right--;
            }
            //控制left 指针比较并右移
            while (left < right && array[left] <= pivot){
                left++;
            }
            //交换left和right 指针所指向的元素
            if (left < right){
                int p = array[left];
                array[left] = array[right];
                array[right] = p;
            }
        }
        //pivote 和指针重合点交换
        array[startIndex] = array[left];
        array[left] = pivot;
        return left;
    }

    private static int partition2(int[] arr, int low, int high){
        //基准数据
        int tmp = arr[low];
        while(low < high){
            //当队尾的元素大于等于基准数据时，向前挪动high指针
            while(low < high && arr[high] >= tmp){
                high--;
            }
            //如果队尾元素小于tmp时，需要将其赋值给low
            arr[low] = arr[high];
            //当队首元素小于等于tmp时，向前挪动low指针
            while(low < high && arr[low] <= tmp){
                low++;
            }
            //当队首元素大于tmp时，需要将其赋值给high
            arr[high] = arr[low];
        }
//        System.out.println("第 low：" + low +"  high:" + high + " 数组值："+ Arrays.toString(arr));
        arr[low]=tmp;
        return low;
    }
}
