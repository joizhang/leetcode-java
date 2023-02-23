package com.joizhang.lc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 */
public class Q56MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length < 2) return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> mergedIntervals = new ArrayList<>();
        // 先加进去结果集，再修改，就不会漏了最后一个
        int[] newInterval = intervals[0];
        mergedIntervals.add(newInterval);
        for (int[] interval : intervals) {
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
        Q56MergeIntervals test = new Q56MergeIntervals();
        int[][] intervals = test.merge(new int[][]{
                new int[]{2, 6},
                new int[]{1, 3},
                new int[]{8, 10},
                new int[]{15, 18},
        });
        System.out.println(Arrays.deepToString(intervals));
    }
}
