package com.joizhang.lc.dp.array;

/**
 * 70. 爬楼梯
 */
public class Q070ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 2) return 1;
        int[] dp = new int[]{1, 1};
        for (int i = 2; i <= n; i++) {
            int temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp + dp[1];
        }
        return dp[1];
    }

    public static void main(String[] args) {
        Q070ClimbingStairs test = new Q070ClimbingStairs();
        System.out.println(test.climbStairs(2));
        System.out.println(test.climbStairs(3));
    }
}
