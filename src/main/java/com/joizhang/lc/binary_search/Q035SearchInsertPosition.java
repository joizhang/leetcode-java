package com.joizhang.lc.binary_search;

/**
 * 35. Search Insert Position
 */
public class Q035SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return hi + 1;
    }

    public static void main(String[] args) {
        Q035SearchInsertPosition test = new Q035SearchInsertPosition();
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 2));
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 7));
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 0));
    }
}
