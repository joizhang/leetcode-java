package com.joizhang.lcof.hash;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 剑指 Offer 50. 第一个只出现一次的字符
 */
public class Offer50 {
    public char firstUniqChar(String s) {
        if (s.isEmpty()) return ' ';
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        Offer50 test = new Offer50();
        System.out.println(test.firstUniqChar("abaccdeff"));
        System.out.println(test.firstUniqChar(""));
        System.out.println(test.firstUniqChar("leetcode"));
    }
}
