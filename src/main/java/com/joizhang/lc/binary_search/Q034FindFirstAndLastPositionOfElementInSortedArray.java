package com.joizhang.lc.binary_search;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 */
public class Q034FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) return ans;

        int leftPos = searchLeftPos(nums, target);
        if (leftPos == -1) {
            return ans;
        }
        ans[0] = leftPos;

        int rightPos = searchRightPos(nums, target);
        ans[1] = rightPos;

        return ans;
    }

    private int searchLeftPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    private int searchRightPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if (nums[hi] == target) {
            return hi;
        }
        return -1;
    }

    public static void main(String[] args) {
        Q034FindFirstAndLastPositionOfElementInSortedArray test =
                new Q034FindFirstAndLastPositionOfElementInSortedArray();
        System.out.println(Arrays.toString(test.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{5,7,7,8,8,10}, 6)));
        System.out.println(Arrays.toString(test.searchRange(new int[]{}, 0)));
    }
}
