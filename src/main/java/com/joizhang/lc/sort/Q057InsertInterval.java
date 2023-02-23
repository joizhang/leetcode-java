package com.joizhang.lc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 57. 插入区间
 */
public class Q057InsertInterval {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals == null || intervals.length == 0) {
            return new int[][]{newInterval};
        }
        // 先将区间插入区间列表
        List<int[]> intervalList = new ArrayList<>(intervals.length + 1);
        for (int[] interval : intervals) {
            if (newInterval[0] <= interval[0]) {
                intervalList.add(newInterval);
            }
            intervalList.add(interval);
        }
        // 考虑newInterval要插入最后的情况
        if (intervalList.size() == intervals.length) {
            intervalList.add(newInterval);
        }

        // 再进行区间合并
        List<int[]> mergedIntervals = new ArrayList<>();
        newInterval = intervalList.get(0);
        mergedIntervals.add(newInterval);
        for (int[] interval : intervalList) {
            if (interval[0] > newInterval[1]) {
                newInterval = interval;
                mergedIntervals.add(newInterval);
            } else {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }

    public static void main(String[] args) {
        Q057InsertInterval test = new Q057InsertInterval();
        int[][] intervals = new int[][]{
                new int[]{1, 3},
                new int[]{6, 9},
        };
        int[] newInterval = new int[]{2, 5};
        int[][] mergedIntervals = test.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(mergedIntervals));

        intervals = new int[][]{
                new int[]{1, 5},
        };
        newInterval = new int[]{2, 7};
        mergedIntervals = test.insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(mergedIntervals));
    }
}
