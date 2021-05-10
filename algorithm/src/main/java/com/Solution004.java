package com;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 题目:
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 示例 4:
 *
 * 输入: s = ""
 * 输出: 0
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution004 {
    /**
     * 滑动窗口算法1
     * 时间复杂度为 O(2n)=O(n),空间复杂度为O(min(m,n))。
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int res = 0;
        int length = s.length();
        HashSet<Character> set = new HashSet<>();
        int left = 0,right = 0;
        while (left < length && right < length){
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                res = Math.max(res,right-left);
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return res;
    }

    /**
     * 滑动窗口算法2 对1的优化
     * 滑动窗口算法的的时间复杂度为线性的(O(n)),我们可以用此算法来查找最大/最小k-子序列，XOR，乘积，总和等一些列问题
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring2(String s) {
        int res = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int length = s.length();
        for (int left = 0,right = 0; left < length && right < length; right++) {
            if (map.containsKey(s.charAt(right))){
                left = Math.max(map.get(s.charAt(right)),left);
            }
            res = Math.max(res,right-left + 1);
            map.put(s.charAt(right),right + 1);
        }
        return res;
    }


    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int length = s.length();
        //滑动窗口算法
        HashMap<Character,Integer> window = new HashMap<>();
        int left = 0,right=0;
        while (right < length){
            //c是将移入窗口的字符串
            char c = s.charAt(right);//右移窗口
            int count = window.getOrDefault(c,0);
            //进行窗口内数据的一系列更新
            window.put(c,++count);
            right++;
            //判断左侧窗口是否收缩
            while(window.getOrDefault(c,0) > 1){
                count = window.get(s.charAt(left));
                //将字符串移除
                window.put(s.charAt(left),--count);
                //左移窗口
                left++;
            }
            if (res < right - left){
                res = right -left;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution004 solution004 = new Solution004();
        int rst = solution004.lengthOfLongestSubstring2("pwwkew");
        System.out.println(rst);
    }
}
