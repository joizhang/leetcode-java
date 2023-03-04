package com.joizhang.lc.array;

import java.util.Arrays;

/**
 * 48. 旋转图像
 */
public class Q048RotateImage {
    public void rotate(int[][] matrix) {
        mainDiagSymmetry(matrix);
        leftRightSymmetry(matrix);
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int temp = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = temp;
    }

    // 上下对称：matrix[i][j] -> matrix[n-i-1][j]，（列不变）
    private void upDownSymmetry(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < n; j++) {
                swap(matrix, i, j, n - 1 - i, j);
            }
        }
    }

    // 左右对称：matrix[i][j] -> matrix[i][n-j-1]，（行不变）
    private void leftRightSymmetry(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {
                swap(matrix, i, j, i, n - 1 - j);
            }
        }
    }

    // 主对角线对称：matrix[i][j] -> matrix[j][i]，（行列互换）
    private void mainDiagSymmetry(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    // 副对角线对称：matrix[i][j] -> matrix[n-j-1][n-i-1] （行列均变，且互换）
    private void subdiagSymmetry(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                swap(matrix, i, j, n - 1 - j, n - 1 - i);
            }
        }
    }

    public static void main(String[] args) {
        Q048RotateImage test = new Q048RotateImage();
        int[][] matrix = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9},
        };
        test.rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
