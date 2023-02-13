package com.joizhang.lc.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 804. 唯一摩尔斯密码词
 */
public class Q804UniqueMorseCodeWords {
    private static final String[] MORSE_CODE = new String[]{
            ".-", "-...", "-.-.", "-..", ".", "..-.", "--.",
            "....", "..", ".---", "-.-", ".-..", "--", "-.",
            "---", ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--", "--.."
    };

    public int uniqueMorseRepresentations(String[] words) {
        if (words == null || words.length == 0) return 0;
        Set<String> set = new HashSet<>();
        for (String word : words) {
            StringBuilder s = new StringBuilder();
            for (char c : word.toCharArray()) {
                s.append(MORSE_CODE[c - 'a']);
            }
            set.add(s.toString());
        }
        return set.size();
    }

    public static void main(String[] args) {
        Q804UniqueMorseCodeWords test = new Q804UniqueMorseCodeWords();
        System.out.println(test.uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(test.uniqueMorseRepresentations(new String[]{"a"}));
    }
}
