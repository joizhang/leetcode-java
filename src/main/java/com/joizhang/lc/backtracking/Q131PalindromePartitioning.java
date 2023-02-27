package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Q131PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), ans);
        return ans;
    }

    private void backtrack(String s, int start, List<String> track, List<List<String>> ans) {
        if (start == s.length()) {
            ans.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i < s.length(); i++) {
            if (!isPalindrome(s, start, i)) continue;
            track.add(s.substring(start, i + 1));
            backtrack(s, i + 1, track, ans);
            track.remove(track.size() - 1);
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        Q131PalindromePartitioning test = new Q131PalindromePartitioning();
        System.out.println(test.partition("a"));
        System.out.println(test.partition("aab"));
    }
}
