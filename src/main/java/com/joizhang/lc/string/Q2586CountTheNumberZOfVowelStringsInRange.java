package com.joizhang.lc.string;

import java.util.Arrays;
import java.util.HashSet;

public class Q2586CountTheNumberZOfVowelStringsInRange {

    private static final HashSet<Character> VOWEL_SET = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));

    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            String word = words[i];
            if (VOWEL_SET.contains(word.charAt(0)) &&
                    VOWEL_SET.contains(word.charAt(word.length() - 1))) {
                ans += 1;
            }
        }
        return ans;
    }
}
