package com.joizhang.lc.array;

import java.util.Arrays;

public class Q867TransposeMatrix {

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int[][] ans = new int[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    public static void main(String[] args) {
        Q867TransposeMatrix test = new Q867TransposeMatrix();
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        System.out.println(Arrays.deepToString(test.transpose(matrix)));
        matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
        };
        System.out.println(Arrays.deepToString(test.transpose(matrix)));
    }
}
