package com.joizhang.lcof.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 */
public class Offer57II {
    public int[][] findContinuousSequence(int target) {
        List<int[]> ans = new ArrayList<>();
        int i = 1, j = 2;
        int s = i + j;
        while (i < j) {
            if (s == target) {
                int[] temp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    temp[k - i] = k;
                }
                ans.add(temp);
            }

            if (s >= target) { // 右移动左边界
                s -= i;
                i += 1;
            } else { // 右移动右边界
                j += 1;
                s += j;
            }
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        Offer57II test = new Offer57II();
        System.out.println(Arrays.deepToString(test.findContinuousSequence(9)));
        System.out.println(Arrays.deepToString(test.findContinuousSequence(15)));
    }
}
