package com.joizhang.lc.math;

/**
 * 136. 只出现一次的数字
 */
public class Q136SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            ans ^= num;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q136SingleNumber test = new Q136SingleNumber();
        System.out.println(test.singleNumber(new int[]{2,2,1}));
        System.out.println(test.singleNumber(new int[]{4,1,2,1,2}));
        System.out.println(test.singleNumber(new int[]{1}));
    }
}
