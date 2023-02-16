package com.joizhang.lcof.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 38. 字符串的排列
 */
public class Offer38 {
    public String[] permutation(String s) {
        if (s == null || s.length() == 0) return new String[0];
        List<String> res = new ArrayList<>();
        boolean[] visited = new boolean[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        backtrack(chars, new StringBuilder(), visited, res);
        return res.toArray(new String[0]);
    }

    private void backtrack(char[] chars, StringBuilder track, boolean[] visited, List<String> res) {
        if (chars.length == track.length()) {
            res.add(track.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i]) continue;
            if (i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) continue;
            visited[i] = true;
            track.append(chars[i]);
            backtrack(chars, track, visited, res);
            track.deleteCharAt(track.length() - 1);
            visited[i] = false;
        }
    }

    public static void main(String[] args) {
        Offer38 test = new Offer38();
        System.out.println(Arrays.toString(test.permutation("a")));
        System.out.println(Arrays.toString(test.permutation("ab")));
        System.out.println(Arrays.toString(test.permutation("bb")));
        System.out.println(Arrays.toString(test.permutation("abc")));
        System.out.println(Arrays.toString(test.permutation("abb")));
    }
}
