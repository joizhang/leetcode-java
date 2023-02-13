package com.joizhang.lc.dp.array;

/**
 * 509. 斐波那契数
 */
public class Q509Fibonacci {
    public int fib(int N) {
        if (N < 2) return N;
        int[] dp = new int[]{0, 1};
        for (int i = 2; i <= N; i++) {
            int temp = dp[0];
            dp[0] = dp[1];
            dp[1] = temp + dp[1];
        }
        return dp[1];
    }

    public static void main(String[] args) {
        Q509Fibonacci test = new Q509Fibonacci();
        System.out.println(test.fib(2));
        System.out.println(test.fib(3));
        System.out.println(test.fib(4));
        System.out.println(test.fib(30));
    }
}
