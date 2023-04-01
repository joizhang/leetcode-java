package com.joizhang.lc.dp.path;

import java.util.Arrays;

/**
 * 174. 地下城游戏
 */
public class Q174DungeonGame {
    // 关键不在于吃最多的血瓶，而是在于如何损失最少的生命值。
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]) - dungeon[i][j];
                dp[i][j] = Math.max(need, 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        Q174DungeonGame test = new Q174DungeonGame();
        int[][] dungeon = new int[][]{
                new int[]{-2, -3, 3},
                new int[]{-5, -10, 1},
                new int[]{10, 30, -5},
        };
        System.out.println(test.calculateMinimumHP(dungeon));
    }
}
