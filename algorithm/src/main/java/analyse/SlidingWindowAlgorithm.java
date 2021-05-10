package analyse;

public class SlidingWindowAlgorithm {

    /**
     * 滑动窗口数组 连续K个字符串数组求和
     * @param arrays 数组
     * @param k  连续个数
     * @return
     */
    public static int maxSum(int[] arrays, int k){
        int sum = 0;
        int length = arrays.length;
        for (int left = 0; left < length- k + 1; left++){
            int tmpSum = 0;
            for (int i = 0; i < k; i++) {
                tmpSum += arrays[left+i];
            }
            sum = Math.max(sum,tmpSum);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arrays = {100,800,200,300,400,200};
        int k = 2;
        int sum = maxSum(arrays,k);
        System.out.println(sum);
    }
}
