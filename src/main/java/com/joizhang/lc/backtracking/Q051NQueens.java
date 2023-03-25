package com.joizhang.lc.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N 皇后
 */
public class Q051NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }
        List<List<String>> ans = new ArrayList<>();
        backtrack(board, 0, ans);
        return ans;
    }

    private void backtrack(char[][] board, int row, List<List<String>> ans) {
        if (row == board.length) {
            ans.add(construct(board));
            return;
        }

        for (int col = 0; col < board.length; col++) {
            if (validate(board, row, col)) {
                board[row][col] = 'Q';
                backtrack(board, row + 1, ans);
                board[row][col] = '.';
            }
        }
    }

    private List<String> construct(char[][] board) {
        List<String> ans = new ArrayList<>();
        for (char[] row : board) {
            String s = new String(row);
            ans.add(s);
        }
        return ans;
    }

    private boolean validate(char[][] board, int row, int col) {
        // 检查列是否有皇后互相冲突
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // 检查左上方是否有皇后互相冲突
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // 检查右上方是否有皇后互相冲突
        for (int i = row - 1, j = col + 1; i >= 0 && j <= board.length - 1; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Q051NQueens test = new Q051NQueens();
        List<List<String>> board = test.solveNQueens(1);
        board.forEach(System.out::println);
        board = test.solveNQueens(4);
        board.forEach(System.out::println);
    }
}
