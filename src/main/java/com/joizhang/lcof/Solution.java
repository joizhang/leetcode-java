package com.joizhang.lcof;

public class Solution {

    public int strToInt(String str) {
        if (str == null) return 0;
        char[] s = str.trim().toCharArray();
        if (s.length == 0) return 0;
        int symbol = 1, i = 0, ans = 0;
        if (s[i] == '-') {
            symbol = -1;
            i++;
        } else if (s[i] == '+') {
            i++;
        }

        while (i < s.length) {
            if (!Character.isDigit(s[i])) break;
            if (s[i] == ' ') {
                i++;
                continue;
            }
            int num = (s[i] - '0') * symbol;
            int MAX_VALUE_DIV_10 = Integer.MAX_VALUE / 10;
            if (ans > MAX_VALUE_DIV_10 || (ans == MAX_VALUE_DIV_10 && num > 7)) {
                return Integer.MAX_VALUE;
            }
            int MIN_VALUE_DIV_10 = Integer.MIN_VALUE / 10;
            if (ans < MIN_VALUE_DIV_10 || (ans == MIN_VALUE_DIV_10 && num < -8)) {
                return Integer.MIN_VALUE;
            }
            ans = ans * 10 + num;
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.strToInt("42"));
    }
}
