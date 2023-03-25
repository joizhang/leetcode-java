package com.joizhang.lc.dp.array;

import java.util.Arrays;

/**
 * 300. Longest Increasing Subsequence
 */
public class Q300LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public int lengthOfLIS2(int[] nums) {
        int n = nums.length;
        int[] tails = new int[n];
        int size = 0;
        for (int num : nums) {
            int i = 0, j = size;
            while (i != j) {
                int m = (i + j) / 2;
                if (tails[m] < num) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) {
        Q300LongestIncreasingSubsequence test = new Q300LongestIncreasingSubsequence();
        System.out.println(test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));

        System.out.println(test.lengthOfLIS2(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
