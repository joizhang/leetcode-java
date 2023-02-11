package com.joizhang.lcof.string;

/**
 * 剑指 Offer 20. 表示数值的字符串
 */
public class Offer20 {
    public boolean isNumber(String s) {
        if (s == null || s.isEmpty()) return false;
        boolean isNum = false, isDot = false, isE = false;
        String s1 = s.trim();
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            if (c >= '0' && c <= '9') {
                // 判断当前字符是否为 0~9 的数位
                isNum = true;
            } else if (c == '.') {
                // 遇到小数点
                if (isDot || isE) {
                    return false;
                }
                isDot = true;
            } else if (c == 'e' || c == 'E') {
                // 遇到'e'或'E'
                if (!isNum || isE) {
                    return false;
                }
                isE = true;
                isNum = false;
            } else if (c == '-' || c == '+') {
                // 正负号只可能出现在第一个位置，或者出现在'e'或'E'的后面一个位置
                if (i != 0 && s1.charAt(i - 1) != 'e' && s1.charAt(i - 1) != 'E') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return isNum;
    }

    public static void main(String[] args) {
        Offer20 test = new Offer20();
        String[] validSample = new String[]{"+100", "5e2", "-123", "3.1416", "-1E-16", "0123"};
        for (String sample: validSample) {
            System.out.print(test.isNumber(sample) + ",");
        }
        System.out.println();
        String[] invalidSample = new String[]{"12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"};
        for (String sample: invalidSample) {
            System.out.print(test.isNumber(sample) + ",");
        }
    }
}
