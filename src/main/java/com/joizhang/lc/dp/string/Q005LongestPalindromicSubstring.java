package com.joizhang.lc.dp.string;

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
        return s;
    }

    public static void main(String[] args) {
        Q005LongestPalindromicSubstring test = new Q005LongestPalindromicSubstring();
        System.out.println(test.longestPalindrome("babad"));
        System.out.println(test.longestPalindrome("cbbd"));
    }
}
