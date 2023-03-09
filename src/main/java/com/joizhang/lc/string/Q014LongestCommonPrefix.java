package com.joizhang.lc.string;

/**
 * 14. Longest Common Prefix
 */
public class Q014LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder res = new StringBuilder();
        String str = strs[0];
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                String temp = strs[j];
                if (i == temp.length() || c != temp.charAt(i)) {
                    return res.toString();
                }
            }
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Q014LongestCommonPrefix test = new Q014LongestCommonPrefix();
        System.out.println(test.longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(test.longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
