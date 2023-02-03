package com.joizhang.lcof.two_pointers;

import java.util.Arrays;

/**
 * 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面
 */
public class Offer21 {
    public int[] exchange(int[] nums) {
        if (nums == null) return new int[0];
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo < hi) {
            // 注意：条件为lo < hi
            while (lo < hi && nums[lo] % 2 != 0) {
                lo++;
            }
            while (lo < hi && nums[hi] % 2 == 0) {
                hi--;
            }
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
        return nums;
    }

    public static void main(String[] args) {
        Offer21 test = new Offer21();
        System.out.println(Arrays.toString(test.exchange(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(test.exchange(new int[]{1, 3, 5})));
    }
}
