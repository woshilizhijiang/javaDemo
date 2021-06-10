package com;

public class DynamicAlgorithm {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(climbStairs(45));
        System.out.println("递归调用耗时：" + (System.currentTimeMillis() - start) + " ms。");
        long start2 = System.currentTimeMillis();
        System.out.println(climbStairsDynamic(45));
        System.out.println("动态规划调用耗时：" + (System.currentTimeMillis() - start2) + " ms。");
    }

    /**
     * 爬楼梯-递归调用
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        int[] a = new int[n+1];
        a[0]=1;
        a[1]=1;
        for (int i = 2; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];
    }

    /**
     * 爬楼梯-动态规划
     * @param n
     * @return
     */
    public static int climbStairsDynamic(int n) {
        if (n <= 2) return n;
        int a1 = 1, a2 = 2;
        for (int i = 3; i <= n; i++) {
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }
}
