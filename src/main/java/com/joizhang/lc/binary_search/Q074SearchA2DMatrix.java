package com.joizhang.lc.binary_search;

/**
 * 74. Search a 2D Matrix
 */
public class Q074SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length, m = matrix[0].length;
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Q074SearchA2DMatrix test = new Q074SearchA2DMatrix();
        int[][] matrix = new int[][]{
                new int[]{1, 3, 5, 7},
                new int[]{10, 11, 16, 20},
                new int[]{23, 30, 34, 60},
        };
        System.out.println(test.searchMatrix(matrix, 3));
        System.out.println(test.searchMatrix(matrix, 13));
    }
}
