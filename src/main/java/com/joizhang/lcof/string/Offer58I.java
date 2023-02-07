package com.joizhang.lcof.string;

/**
 * 剑指 Offer 58 - I. 翻转单词顺序
 */
public class Offer58I {
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
        Offer58I test = new Offer58I();
        System.out.println(test.reverseWords("the sky is blue"));
        System.out.println(test.reverseWords("  hello world!  "));
        System.out.println(test.reverseWords("a good   example"));
        System.out.println(test.reverseWords(" "));
    }
}
