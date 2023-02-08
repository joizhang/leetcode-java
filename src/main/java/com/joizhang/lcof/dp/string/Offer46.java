package com.joizhang.lcof.dp.string;

/**
 * 剑指 Offer 46. 把数字翻译成字符串
 */
public class Offer46 {
    public int translateNum(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        int[] dp = new int[len + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= len; i++) {
            String temp = s.substring(i - 2, i);
            if (temp.compareTo("10") >= 0 && temp.compareTo("25") <= 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        Offer46 test = new Offer46();
        System.out.println(test.translateNum(12258));
    }
}
