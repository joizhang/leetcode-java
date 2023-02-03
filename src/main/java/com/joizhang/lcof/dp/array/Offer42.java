package com.joizhang.lcof.dp.array;

/**
 * 剑指 Offer 42. 连续子数组的最大和
 */
public class Offer42 {
    public int maxSubArray(int[] nums) {
        // 设置动态规划数组dp，dp[i]表示以元素nums[i]为结尾的连续子数组最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer42 test = new Offer42();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
