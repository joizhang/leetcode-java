package com.joizhang.lcof.string;

/**
 * 剑指 Offer 58 - II. 左旋转字符串
 */
public class Offer58II {
    public String reverseLeftWords(String s, int n) {
        assert 1 <= n && n < s.length();
        return s.substring(n) + s.substring(0, n);
    }

    public String reverseLeftWords2(String s, int n) {
        assert 1 <= n && n < s.length();
        char[] chars = s.toCharArray();
        reverse(chars, 0, n - 1);
        reverse(chars, n, s.length() - 1);
        reverse(chars, 0, s.length() - 1);
        return String.valueOf(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start += 1;
            end -= 1;
        }
    }

    public static void main(String[] args) {
        Offer58II test = new Offer58II();
        System.out.println(test.reverseLeftWords("abcdefg", 2));
        System.out.println(test.reverseLeftWords("lrloseumgh", 6));

        System.out.println(test.reverseLeftWords2("abcdefg", 2));
        System.out.println(test.reverseLeftWords2("lrloseumgh", 6));
    }
}
