package com.joizhang.lc.math;

import java.util.Arrays;

/**
 * 238. Product of Array Except Self
 */
public class Q238ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        // 从前往后乘
        int[] arr1 = new int[n];
        arr1[0] = nums[0];
        for (int i = 1; i < n; i++) {
            arr1[i] = arr1[i - 1] * nums[i];
        }
        // 从后往前乘
        int[] arr2 = new int[n];
        arr2[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            arr2[i] = arr2[i + 1] * nums[i];
        }

        int[] res = new int[n];
        res[0] = 1 * arr2[1];
        res[n - 1] = arr1[n - 2] * 1;
        for (int i = 1; i < n - 1; i++) {
            res[i] = arr1[i - 1] * arr2[i + 1];
        }
        return res;
    }

    public static void main(String[] args) {
        Q238ProductOfArrayExceptSelf test = new Q238ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(test.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
