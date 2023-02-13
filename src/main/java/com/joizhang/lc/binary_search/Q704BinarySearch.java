package com.joizhang.lc.binary_search;

/**
 * 704. 二分查找
 * <a href="https://leetcode.cn/problems/binary-search/solution/er-fen-cha-zhao-xiang-jie-by-labuladong/">...</a>
 */
public class Q704BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q704BinarySearch test = new Q704BinarySearch();
        System.out.println(test.search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(test.search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        System.out.println(test.search(new int[]{5}, 5));
    }
}
