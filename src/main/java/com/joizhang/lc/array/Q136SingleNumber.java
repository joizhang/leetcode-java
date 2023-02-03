package com.joizhang.lc.array;

/**
 * 136. 只出现一次的数字
 */
public class Q136SingleNumber {
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
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
