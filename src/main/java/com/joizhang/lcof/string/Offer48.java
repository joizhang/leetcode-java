package com.joizhang.lcof.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 剑指 Offer 48. 最长不含重复字符的子字符串
 */
public class Offer48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(c, i);
        }
        return res;
    }

    public static void main(String[] args) {
        Offer48 test = new Offer48();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
    }
}
