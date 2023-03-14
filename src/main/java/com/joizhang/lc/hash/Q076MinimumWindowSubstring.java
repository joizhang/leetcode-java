package com.joizhang.lc.hash;

import com.joizhang.imooc.datastructure.HashMap;

/**
 * 76. Minimum Window Substring
 */
public class Q076MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s == null || s.length() < t.length() || s.length() == 0) {
            return "";
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        int left = 0;
        int minLeft = 0;
        int minLen = s.length() + 1;
        int count = 0;
        for (int right = 0; right < s.length(); right++) {
            char rightChar = s.charAt(right);
            if (map.containsKey(rightChar)) {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) >= 0) {
                    count++;
                }
                while (count == t.length()) {
                    if (right - left + 1 < minLen) {
                        minLeft = left;
                        minLen = right - left + 1;
                    }
                    char leftChar = s.charAt(left);
                    if (map.containsKey(leftChar)) {
                        map.put(leftChar, map.get(leftChar) + 1);
                        if (map.get(leftChar) > 0) {
                            count--;
                        }
                    }
                    left++;
                }
            }
        }
        if (minLen > s.length()) {
            return "";
        }
        return s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        Q076MinimumWindowSubstring test = new Q076MinimumWindowSubstring();
        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));
        System.out.println(test.minWindow("a", "a"));
        System.out.println(test.minWindow("a", "aa"));
    }
}
