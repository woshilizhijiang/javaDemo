package mycom.utils.datastructureandalgorithm.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 要求：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 *
 思路：
 如何跳上第n阶？
 方法一：在第n-1阶向上跳1级
 方法二：在第n-2阶向上跳2级
 所以跳上第n阶的跳法等于 跳上第n-1阶的跳法 加上 跳上第n-2阶的跳法
 * Created by 20013649 on 2020/6/23.
 */
public class JumpFloor {
    private static AtomicInteger count = new AtomicInteger(0);

    public static void main(String[] args){
        long start = System.nanoTime();

        JumpFloor jumpFloor = new JumpFloor();
        int floors = 30;
        //递归算法
//        int result = jumpFloor.jumpFloorRecursion(floors);
        //备忘录算法
        Map<Integer,Integer> map = new HashMap<>();
        int result = jumpFloor.jumpFloorMemoMap(floors, map);
        //动态规划算法
//        int result = jumpFloor.jumpFloorDynamicPrg(floors);
//        int result = jumpFloor.jumpFloor3DynamicPrg(floors);

        long end = System.nanoTime();

        System.out.println("result : " + result);
        System.out.println("Execution times : " + count.get());
        System.out.println("Execution time : " + (end - start)/1000 + " 微秒");
    }

    /**
     *  台阶可以为 1 ， 2 ，3
     * @param target
     * @return
     */
    public int jumpFloor3DynamicPrg(int target){
        if (target < 0) return 0;
        if (target == 1 || target == 2) return target;
        if (target == 3) return 4;
        int a = 1;
        int b = 2;
        int c = 4;
        int total =0;
        for(int i = 4;i <= target ;i++){
            count.incrementAndGet();
            total = a + b + c;
            a = b;
            b = c;
            c = total;
        }
        return total;
    }

    /**
     * 动态规划算法
     target ： 30
     result : 1346269
     Execution times : 28
     Execution time : 25 微秒
     * @param target
     * @return
     */
    public int jumpFloorDynamicPrg(int target){
        if (target < 0) return 0;
        if (target == 1 || target == 2) return target;
        int a = 1;
        int b = 2;
        int temp =0;
        for(int i = 3;i <= target ;i++){
            count.incrementAndGet();
            temp = b + a;
            a = b;
            b = temp;
        }
        return temp;
    }

    /**
     * 备忘录算法
     * 该方法记录了每一种结果；相对占用更多的内存空间；
     target ： 30
     result : 1346269
     Execution times : 54
     Execution time : 186 微秒
     * @param target
     * @param map
     * @return
     */
    public int jumpFloorMemoMap(int target, Map<Integer,Integer> map){
        if (target < 0) return 0;
        if (target == 1 || target == 2) return target;
        count.incrementAndGet();

        if (map.containsKey(target)){
            return map.get(target);
        }else {
            int val = jumpFloorMemoMap(target - 1,map) + jumpFloorMemoMap(target - 2,map);
            map.put(target, val);
            return val;
        }
    }

    /**
     * 递归算法
     target ： 30
     result : 1346269
     Execution times : 832039
     Execution time : 12582 微秒
     * @param target
     * @return
     */
    public int jumpFloorRecursion(int target){
        if (target < 0) return 0;
        if (target == 1 || target == 2) return target;
        count.incrementAndGet();
        int sum = jumpFloorRecursion(target-1) + jumpFloorRecursion(target-2);
        return sum;
    }
}
