package com.joizhang.lc.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果c已经存在，则更新滑动窗口的其实位置
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            // 获取当前滑动窗口的大小
            res = Math.max(res, i - start + 1);
            map.put(s.charAt(i), i);
        }
        return res;
    }

    public static void main(String[] args) {
        Q3LongestSubstringWithoutRepeatingCharacters test = new Q3LongestSubstringWithoutRepeatingCharacters();
        System.out.println(test.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.lengthOfLongestSubstring("bbbbb"));
        System.out.println(test.lengthOfLongestSubstring("pwwkew"));
        System.out.println(test.lengthOfLongestSubstring(""));
        System.out.println(test.lengthOfLongestSubstring("bcbb"));
    }
}
