package com.joizhang.lcof.string;

/**
 * 面试题67. 把字符串转换成整数
 */
public class Offer67 {
    private static final int MAX_INT_DIV_10 = Integer.MAX_VALUE / 10;
    private static final int MIN_INT_DIV_10 = Integer.MIN_VALUE / 10;

    public int strToInt(String str) {
        if (str == null || str.length() == 0) return 0;
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        int ans = 0, symbol = 1;
        int i = 0;
        if (s[i] == '-') {
            symbol = -1;
            i++;
        } else if (s[i] == '+') {
            i++;
        }

        while (i < s.length) {
            if (!Character.isDigit(s[i])) break;
            if (s[i] == ' ') continue;
            int num = symbol * (s[i] - '0');
            if (ans > MAX_INT_DIV_10 || (ans == MAX_INT_DIV_10 && num > 7)) {
                return Integer.MAX_VALUE;
            }
            if (ans < MIN_INT_DIV_10 || (ans == MIN_INT_DIV_10 && num < -8)) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + num;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Offer67 test = new Offer67();
        System.out.println(test.strToInt(""));
        System.out.println(test.strToInt("42"));
        System.out.println(test.strToInt("   -42"));
        System.out.println(test.strToInt("4193 with words"));
        System.out.println();
        System.out.println(test.strToInt("2147483646"));
        System.out.println(test.strToInt("2147483647"));
        System.out.println(test.strToInt("2147483648"));
        System.out.println();
        System.out.println(test.strToInt("-2147483647"));
        System.out.println(test.strToInt("-2147483648"));
        System.out.println(test.strToInt("-2147483649"));
        System.out.println();
        System.out.println(test.strToInt("-91283472332"));
    }
}
