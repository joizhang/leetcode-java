package com.joizhang.lcof.binary_search;

/**
 * 剑指 Offer 04. 二维数组中的查找
 */
public class Offer04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0)return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
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
        Offer04 test = new Offer04();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}

        };
        System.out.println(test.findNumberIn2DArray(matrix, 1));
        System.out.println(test.findNumberIn2DArray(matrix, 30));
    }
}
