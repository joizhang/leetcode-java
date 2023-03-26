package com.joizhang.lc.string;

/**
 * 8. String to Integer (atoi)
 */
public class Q008StringToInteger {
    private static final int MAX_VALUE_DIV_10 = Integer.MAX_VALUE / 10;
    private static final int MIN_VALUE_DIV_10 = Integer.MIN_VALUE / 10;

    public int myAtoi(String s) {
        // 忽略前导空格
        // 正负号只会出现在开头
        // 接着循环读取下一个字符，直到当前字符不为数字，剩下的字符直接忽略
        // 范围在[-2^31, 2^(31 - 1)]
        if (s == null || s.isEmpty()) return 0;
        char[] charArray = s.trim().toCharArray();
        if (charArray.length == 0) return 0;
        int ans = 0, symbol = 1, i = 0;
        if (charArray[0] == '-') {
            symbol = -1;
            i++;
        } else if (charArray[0] == '+') {
            i++;
        }

        while (i < charArray.length) {
            if (!Character.isDigit(charArray[i])) break;
            int num = symbol * (charArray[i] - '0');
            if (ans > MAX_VALUE_DIV_10 || (ans == MAX_VALUE_DIV_10 && num > 7)) {
                return Integer.MAX_VALUE;
            } else if (ans < MIN_VALUE_DIV_10 || (ans == MIN_VALUE_DIV_10 && num < -8)) {
                return Integer.MIN_VALUE;
            } else {
                ans = ans * 10 + num;
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q008StringToInteger test = new Q008StringToInteger();
        System.out.println(test.myAtoi("42"));
        System.out.println(test.myAtoi("   -42"));
        System.out.println(test.myAtoi("4193 with words"));
        System.out.println(test.myAtoi("2147483646"));
        System.out.println(test.myAtoi("2147483647"));
        System.out.println(test.myAtoi("2147483648"));
        System.out.println(test.myAtoi("-2147483647"));
        System.out.println(test.myAtoi("-2147483648"));
        System.out.println(test.myAtoi("-2147483649"));
    }
}
