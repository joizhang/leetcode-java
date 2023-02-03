package com.joizhang.lcof.dp.array;

/**
 * 剑指 Offer 47. 礼物的最大价值
 */
public class Offer47 {
    public int maxValue(int[][] grid) {
        if (grid == null) return 0;
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i - 1][j - 1];
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        Offer47 test = new Offer47();
        int[][] grid = new int[][]{
                new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}
        };
        System.out.println(test.maxValue(grid));
    }
}
