package com.joizhang.lc.binary_search;

/**
 * 33. 搜索旋转排序数组
 */
public class Q033SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 注意：使用 <=
            if (nums[lo] <= nums[mid]) { // 左边递增
                if (nums[lo] <= target && target < nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else { // 右边递增
                if (nums[mid] < target && target <= nums[n - 1]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q033SearchInRotatedSortedArray test = new Q033SearchInRotatedSortedArray();
        System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(test.search(new int[]{1}, 0));
        System.out.println(test.search(new int[]{3, 1}, 1));
    }
}
