package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 */
public class Q017LetterCombinationsOfAPhoneNumber {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.isEmpty()) return combinations;
        backtrack(digits, 0, new StringBuilder(), combinations);
        return combinations;
    }

    // index表示digits中的第几个字符
    private void backtrack(String digits, int index, StringBuilder combination, List<String> combinations) {
        if (digits.length() == combination.length()) {
            combinations.add(combination.toString());
            return;
        }
        Character digit = digits.charAt(index);
        String letter = phoneMap.get(digit);
        int letterLen = letter.length();
        for (int i = 0; i < letterLen; i++) {
            combination.append(letter.charAt(i));
            // index + 1表示与下一个letter进行组合
            backtrack(digits, index + 1, combination, combinations);
            combination.deleteCharAt(combination.length() - 1);
        }
    }

    public static void main(String[] args) {
        Q017LetterCombinationsOfAPhoneNumber test = new Q017LetterCombinationsOfAPhoneNumber();
        System.out.println(test.letterCombinations("2"));
        System.out.println(test.letterCombinations("23"));
    }
}
