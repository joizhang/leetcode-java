package com.joizhang.lc.dp.array;

/**
 * 53. 最大子数组和
 */
public class Q053MaximumSubArray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int ans = nums[0], dp = nums[0];
        for (int i = 1; i < n; i++) {
            // dp表示i之前
            dp = Math.max(dp, 0);
            ans = Math.max(ans, nums[i] + dp);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q053MaximumSubArray test = new Q053MaximumSubArray();
        System.out.println(test.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(test.maxSubArray(new int[]{1}));
        System.out.println(test.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }
}
