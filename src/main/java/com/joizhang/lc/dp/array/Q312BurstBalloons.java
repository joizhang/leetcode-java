package com.joizhang.lc.dp.array;

/**
 * 312. 戳气球
 */
public class Q312BurstBalloons {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 2];
        temp[0] = 1;
        temp[n + 1] = 1;
        System.arraycopy(nums, 0, temp, 1, n);
        int[][] dp = new int[n + 2][n + 2];
        // len表示开区间长度
        for (int len = 3; len <= n + 2; len++) {
            // i表示开区间左端点
            for (int i = 0; i <= n + 2 - len; i++) {
                int res = 0;
                // k为开区间内的索引
                for (int k = i + 1; k < i + len - 1; k++) {
                    int left = dp[i][k];
                    int right = dp[k][i + len - 1];
                    res = Math.max(res, left + temp[i] * temp[k] * temp[i + len - 1] + right);
                }
                dp[i][i + len - 1] = res;
            }
        }
        return dp[0][n + 1];
    }

    public static void main(String[] args) {
        Q312BurstBalloons test = new Q312BurstBalloons();
        System.out.println(test.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
