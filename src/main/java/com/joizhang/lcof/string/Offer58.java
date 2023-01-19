package com.joizhang.lcof.string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Offer58 {
    public String reverseLeftWords(String s, int n) {
        assert 1 <= n && n < s.length();
        return s.substring(n) + s.substring(0, n);
    }

    public static void main(String[] args) {
        Offer58 test = new Offer58();
        System.out.println(test.reverseLeftWords("abcdefg", 2));
        System.out.println(test.reverseLeftWords("lrloseumgh", 6));
    }
}
