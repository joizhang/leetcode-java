package com.joizhang.lcof.backtracking;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题13. 机器人的运动范围
 */
public class Offer13 {
    // DFS（深度优先搜索）
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, k, 0, 0);
    }

    private int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
        if (i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) return 0;
        visited[i][j] = true;
        return 1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1);
    }

    private int bitSum(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

    // BFS（广度优先搜索）
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] x = queue.poll();
            int i = x[0], j = x[1];
            if (i >= m || j >= n || visited[i][j] || bitSum(i) + bitSum(j) > k) {
                continue;
            }
            visited[i][j] = true;
            res++;
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }

    public static void main(String[] args) {
        Offer13 test = new Offer13();
        System.out.println(test.movingCount(2, 3, 1));
        System.out.println(test.movingCount(3, 1, 0));
        System.out.println(test.movingCount(38, 15, 9));

        System.out.println(test.movingCount2(2, 3, 1));
        System.out.println(test.movingCount2(3, 1, 0));
        System.out.println(test.movingCount2(38, 15, 9));
    }
}
