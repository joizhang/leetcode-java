package com.joizhang.lc.string;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * 647. 回文子串
 */
public class Q647PalindromicSubstrings {
    public int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += helper(s, i, i);
            count += helper(s, i, i + 1);
        }
        return count;
    }

    private int helper(String s, int i, int j) {
        int count = 0;
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            count++;
            i--;
            j++;
        }
        return count;
    }

    // 动态规划
    public int countSubstrings2(String s) {
        Boolean[][] dp = new Boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = j; i >= 0; i--) {
                boolean charEq = s.charAt(i) == s.charAt(j);
                if (j - i <= 1) {
                    dp[i][j] = charEq;
                } else {
                    dp[i][j] = dp[i + 1][j - 1] && charEq;
                }
            }
        }
        return (int) Arrays.stream(dp)
                .flatMap(Stream::of)
                .filter(Boolean.TRUE::equals)
                .count();
    }

    public static void main(String[] args) {
        Q647PalindromicSubstrings test = new Q647PalindromicSubstrings();
        System.out.println(test.countSubstrings("abc"));
        System.out.println(test.countSubstrings("aaa"));
    }
}
