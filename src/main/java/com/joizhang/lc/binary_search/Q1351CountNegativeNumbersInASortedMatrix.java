package com.joizhang.lc.binary_search;

public class Q1351CountNegativeNumbersInASortedMatrix {

    public int countNegatives(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length, n = grid[0].length;
        int count = 0;
        // 从右上角开始遍历
        for (int i = 0, j = n - 1; i < m && j >= 0; ) {
            if (grid[i][j] >= 0) {
                // 如果当前值大于等于 0，那么前面的值肯定都非负，那么直接跳过，进入下一行, 即 i++
                i++;
            } else {
                // 如果当前值小于 0，那么当前值以及同列下的值都是小于 0 的，那么直接添加，然后进行下一列，即 j--
                count += m - i;
                j--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Q1351CountNegativeNumbersInASortedMatrix test = new Q1351CountNegativeNumbersInASortedMatrix();
        int[][] grid = new int[][]{
                new int[]{4, 3, 2, -1},
                new int[]{3, 2, 1, -1},
                new int[]{1, 1, -1, -2},
                new int[]{-1, -1, -2, -3},
        };
        System.out.println(test.countNegatives(grid));
    }
}
