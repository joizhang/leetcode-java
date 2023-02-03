package com.joizhang.lcof.dp.array;

/**
 * 剑指 Offer 10- II. 青蛙跳台阶问题
 */
public class Offer10II {
    public int numWays(int n) {
        if (n <= 1) return 1;
        int[] ans = new int[]{1, 1};
        for (int i = 2; i <= n; i++) {
            int temp = ans[0];
            ans[0] = ans[1];
            ans[1] = (temp + ans[1]) % 1000000007;
        }
        return ans[1];
    }

    public static void main(String[] args) {
        Offer10II test = new Offer10II();
        System.out.println(test.numWays(0));
        System.out.println(test.numWays(1));
        System.out.println(test.numWays(2));
    }
}
