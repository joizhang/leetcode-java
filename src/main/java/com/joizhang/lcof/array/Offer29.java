package com.joizhang.lcof.array;

import java.util.Arrays;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 */
public class Offer29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0) return new int[0];
        int[] res = new int[matrix.length * matrix[0].length];
        int index = 0;
        int top = 0, bottom = matrix.length - 1, left = 0, right = matrix[0].length - 1;
        while (true) {
            for (int j = left; j <= right; j++) {
                res[index++] = matrix[top][j];
            }
            top++;
            if (top > bottom) break;

            for (int i = top; i <= bottom; i++) {
                res[index++] = matrix[i][right];
            }
            right--;
            if (left > right) break;

            for (int j = right; j >= left; j--) {
                res[index++] = matrix[bottom][j];
            }
            bottom--;
            if (top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                res[index++] = matrix[i][left];
            }
            left++;
            if (left > right) break;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer29 test = new Offer29();
        System.out.println(Arrays.toString(
                test.spiralOrder(new int[][]{
                        new int[]{1, 2, 3},
                        new int[]{4, 5, 6},
                        new int[]{7, 8, 9},
                })
        ));
        System.out.println(Arrays.toString(
                test.spiralOrder(new int[][]{
                        new int[]{1, 2, 3, 4},
                        new int[]{5, 6, 7, 8},
                        new int[]{9, 10, 11, 12},
                })
        ));
    }
}
