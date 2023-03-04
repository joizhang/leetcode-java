package com.joizhang.lc.dp.string;

/**
 * 72. 编辑距离
 */
public class Q072EditDistance {
    public int minDistance(String word1, String word2) {
        return dp(word1, word2, word1.length() - 1, word2.length() - 1);
    }

    private int dp(String word1, String word2, int i, int j) {
        if (i == -1) return j + 1;
        if (j == -1) return i + 1;
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp(word1, word2, i - 1, j - 1);
        } else {
            return Math.min(
                    dp(word1, word2, i, j - 1) + 1, // 插入
                    Math.min(dp(word1, word2, i - 1, j) + 1, // 删除
                            dp(word1, word2, i - 1, j - 1) + 1) // 替换
            );
        }
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        // 第一行，是 word1 为空变成 word2 最少步数，就是插入操作
        for (int i = 0; i < m + 1; i++)  {
            dp[i][0] = i;
        }
        // 第一列，是 word2 为空，需要的最少步数，就是删除操作
        for (int j = 0; j < n + 1; j++)  {
            dp[0][j] = j;
        }
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 增加，删除，替换
                    dp[i][j] = Math.min(dp[i][j - 1], Math.min(dp[i - 1][j], dp[i-1][j-1])) + 1;
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Q072EditDistance test = new Q072EditDistance();
        System.out.println(test.minDistance("horse", "ros"));
        System.out.println(test.minDistance("intention", "execution"));
        System.out.println(test.minDistance2("horse", "ros"));
        System.out.println(test.minDistance2("intention", "execution"));
    }
}
