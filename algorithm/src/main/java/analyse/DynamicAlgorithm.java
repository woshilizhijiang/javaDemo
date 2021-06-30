package analyse;

import org.junit.Test;

/**
 *
 * 动态规划：
 *  自底向上
 *
 * 备忘录模式：以空间换时间
 *  自顶向下
 * 和动态规划时间一致
 *
 */
public class DynamicAlgorithm {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println("recursion result : " + climbStairs(45));
        System.out.println("递归调用耗时：" + (System.currentTimeMillis() - start) + " ms。");
        long start2 = System.currentTimeMillis();
        System.out.println("dynamic result : " + climbStairsDynamic(45));
        System.out.println("动态规划调用耗时：" + (System.currentTimeMillis() - start2) + " ms。");
    }

    /**
     * 爬楼梯-递归调用
     * 耗时
     * @param n
     * @return
     */
    public static int climbStairs(int n) {
        if (1 == n || 2 == n) return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    /**
     * 爬楼梯-动态规划
     * @param n
     * @return
     */
    public static int climbStairsDynamic(int n) {
        if (n <= 2) return n;
        int a1 = 1, a2 = 1;
        for (int i = 3; i <= n; i++) {
            int temp = a1 + a2;
            a1 = a2;
            a2 = temp;
        }
        return a2;
    }

    /**
     * k种货币，面值分别为c1,c2,...,ck每种货币数量无限，给一个总额amount，、
     * 问最少需要几枚硬币凑出这个金额。
     */
    @Test
    public void couLingQian(){

    }


}
