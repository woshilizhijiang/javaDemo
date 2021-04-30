package com;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 *  
 * 提示：
 * 1 <= nums.length <= 3 * 10^4
 * -2^31 <= nums[i] <= 2^31 - 1
 * nums 中，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-number-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution001 {
    public static void main(String[] args) {
        int[] nums = {12,0,1,0,1,0,1,99,77,99,77,77,99};
        Solution001 solution001 = new Solution001();
        System.out.println(solution001.singleNumber2(nums));
    }

    /**
     * 传统map
     * 1.空间复杂度高：
     * 2.时间复杂度O(n) 线性
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }else {
                map.put(nums[i],1);
            }
        }
        int rst = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()
             ) {
            if (entry.getValue() == 1){
                rst = entry.getKey();
            }
        }
        return rst;
    }

    /**
     * 参考热评 牛皮的解法
     * 0 ^ x = x
     * x ^ x = 0
     * x & ~x = 0
     * x & ~0 =x
     * 那么就是很好解释上面的代码了。一开始a = 0, b = 0;
     * x第一次出现后，a = (a ^ x) & ~b的结果为 a = x, b = (b ^ x) & ~a的结果为此时因为a = x了，所以b = 0。
     * x第二次出现：a = (a ^ x) & ~b, a = (x ^ x) & ~0, a = 0; b = (b ^ x) & ~a 化简， b = (0 ^ x) & ~0 ,b = x;
     * x第三次出现：a = (a ^ x) & ~b， a = (0 ^ x) & ~x ,a = 0; b = (b ^ x) & ~a 化简， b = (x ^ x) & ~0 , b = 0;所以出现三次同一个数，a和b最终都变回了0.
     * 只出现一次的数，按照上面x第一次出现的规律可知a = x, b = 0;因此最后返回a.
     * @param nums
     * @return
     */
    public int singleNumber2(int[] nums){
        int a=0,b=0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }
}
