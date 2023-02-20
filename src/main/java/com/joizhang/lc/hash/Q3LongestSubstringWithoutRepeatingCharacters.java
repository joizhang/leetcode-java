package com.joizhang.lc.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int start = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                start = Math.max(start, map.get(c) + 1);
            }
            res = Math.max(res, i - start + 1);
            map.put(c, i);
        }
        return res;
    }

    public static void main(String[] args) {
        Q3LongestSubstringWithoutRepeatingCharacters test = new Q3LongestSubstringWithoutRepeatingCharacters();
        assert 3 == test.lengthOfLongestSubstring("abcabcbb");
        assert 1 == test.lengthOfLongestSubstring("bbbbb");
        assert 3 == test.lengthOfLongestSubstring("pwwkew");
        assert 0 == test.lengthOfLongestSubstring("");
        assert 2 == test.lengthOfLongestSubstring("bcbb");
    }
}
