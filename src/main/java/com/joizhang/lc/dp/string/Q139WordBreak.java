package com.joizhang.lc.dp.string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 139. 单词拆分
 */
public class Q139WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> wordSets = new HashSet<>(wordDict);
        // dp[i] = dp[j] && check(s[j...i-1])
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSets.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Q139WordBreak test = new Q139WordBreak();
        System.out.println(test.wordBreak("leetcode", Arrays.asList("leet", "code")));
        System.out.println(test.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
        System.out.println(test.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
