package com.joizhang.lc.backtracking;

/**
 * 79. 单词搜索
 */
public class Q079WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) return false;
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, m, n, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int m, int n, int i, int j, String word, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '\0' || board[i][j] != word.charAt(k)) {
            return false;
        }
        if (k == word.length() - 1) return true;
        board[i][j] = '\0';
        boolean ans = dfs(board, m, n, i  - 1, j, word, k + 1) ||
                dfs(board, m, n, i, j + 1, word, k + 1) ||
                dfs(board, m, n, i  + 1, j, word, k + 1) ||
                dfs(board, m, n, i, j - 1, word, k + 1);
        board[i][j] = word.charAt(k);
        return ans;
    }

    public static void main(String[] args) {
        Q079WordSearch test = new Q079WordSearch();
        char[][] board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        };
        System.out.println(test.exist(board, "ABCCED"));
        board = new char[][]{
                new char[]{'A', 'B', 'C', 'E'},
                new char[]{'S', 'F', 'C', 'S'},
                new char[]{'A', 'D', 'E', 'E'},
        };
        System.out.println(test.exist(board, "SEE"));
    }
}
