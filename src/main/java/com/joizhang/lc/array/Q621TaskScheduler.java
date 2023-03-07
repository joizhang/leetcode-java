package com.joizhang.lc.array;

/**
 * 621. 任务调度器
 */
public class Q621TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] temp = new int[26];
        int countMaxTask = 0;
        int maxTask = 0;
        for (char c : tasks) {
            temp[c - 'A']++;
            maxTask = Math.max(maxTask, temp[c - 'A']);
        }
        for (int i = 0; i < 26; i++) {
            if (temp[i] == maxTask) {
                countMaxTask++;
            }
        }
        return Math.max(tasks.length, (maxTask - 1) * (n + 1) + countMaxTask);
    }

    public static void main(String[] args) {
        Q621TaskScheduler test = new Q621TaskScheduler();
        System.out.println(test.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 2));
        System.out.println(test.leastInterval(new char[]{'A', 'A', 'A', 'B', 'B', 'B'}, 0));
        System.out.println(test.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
