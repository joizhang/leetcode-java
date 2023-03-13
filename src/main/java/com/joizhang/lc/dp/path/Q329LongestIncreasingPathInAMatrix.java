package com.joizhang.lc.dp.path;

/**
 * 329. Longest Increasing Path in a Matrix
 */
public class Q329LongestIncreasingPathInAMatrix {
    public static final int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m][n];
        int ans = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfs(matrix, m, n, i, j, dp));
            }
        }
        return ans;
    }

    private int dfs(int[][] matrix, int m, int n, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) return dp[i][j];
        int ans = 1;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x < 0 || x >= m || y < 0 || y >= n || matrix[x][y] <= matrix[i][j]) continue;
            ans = Math.max(ans, 1 + dfs(matrix, m, n, x, y, dp));
        }
        dp[i][j] = ans;
        return ans;
    }

    public static void main(String[] args) {
        Q329LongestIncreasingPathInAMatrix test = new Q329LongestIncreasingPathInAMatrix();
        int[][] matrix = new int[][]{
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1},
        };
        System.out.println(test.longestIncreasingPath(matrix));
        matrix = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1},
        };
        System.out.println(test.longestIncreasingPath(matrix));
    }
}
