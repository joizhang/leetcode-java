package com.joizhang.lc.math;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
 */
public class Q013RomanToInteger {
    Map<Character, Integer> romanMap = new HashMap<Character, Integer>(){{
        put('I', 1);
        put('V', 5);
        put('X', 10 );
        put('L', 50);
        put('C', 100);
        put('D', 500);
        put('M', 1000);
    }};

    public int romanToInt(String s) {
        int sum = romanMap.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (romanMap.get(s.charAt(i)) < romanMap.get(s.charAt(i + 1))) {
                sum -= romanMap.get(s.charAt(i));
            } else {
                sum += romanMap.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Q013RomanToInteger test = new Q013RomanToInteger();
        System.out.println(test.romanToInt("III"));
        System.out.println(test.romanToInt("LVIII"));
        System.out.println(test.romanToInt("MCMXCIV"));
    }
}
