package com.joizhang.lc.string;

/**
 * 5. 最长回文子串
 */
public class Q005LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";
        int n = s.length();
        if (s.length() < 2) return s;
        String res = "";
        for (int i = 0; i < n; i++) {
            String temp = helper(s, n, i, i);
            if (temp.length() > res.length()) {
                res = temp;
            }
            temp = helper(s, n, i, i + 1);
            if (temp.length() > res.length()) {
                res = temp;
            }
        }
        return res;
    }

    private String helper(String s, int n, int i, int j) {
        while (i >= 0 && j < n && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return s.substring(i + 1, j);
    }

    public String longestPalindrome2(String s) {
        if (s == null || s.length() < 2) return s;
        int strLen = s.length();
        // 最长回文串的起点，最长回文串的终点
        int maxStart = 0, maxEnd = 0, maxLen = 1;
        boolean[][] dp = new boolean[strLen][strLen];
        for (int r = 1; r < strLen; r++) {
            for (int l = 0; l < r; l++) {
                if (s.charAt(l) == s.charAt(r) && (r - l <= 2 || dp[l + 1][r - 1])) {
                    dp[l][r] = true;
                    if (r - l + 1 > maxLen) {
                        maxLen = r - l + 1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        Q005LongestPalindromicSubstring test = new Q005LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));

        System.out.println(test.longestPalindrome2("babad"));
        System.out.println(test.longestPalindrome2("cbbd"));
    }
}
