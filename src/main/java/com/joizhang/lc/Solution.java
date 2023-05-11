package com.joizhang.lc;

public class Solution {

    public String reverseWords(String s) {
        if (s == null || s.isEmpty()) return s;
        String[] splitArr = s.trim().split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = splitArr.length - 1; i >= 0; i--) {
            if ("".equals(splitArr[i])) continue;
            res.append(splitArr[i]).append(" ");
        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
    }
}
