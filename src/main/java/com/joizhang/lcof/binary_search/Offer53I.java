package com.joizhang.lcof.binary_search;

/**
 * 剑指 Offer 53 - I. 在排序数组中查找数字 I
 */
public class Offer53I {
    public int search(int[] nums, int target) {
        int[] ans = new int[]{-1, -1};
        if (nums.length == 0) return 0;
        // 最左边
        int pos = this.findFirstPos(nums, target);
        if (pos == -1) return 0;
        ans[0] = pos;
        // 最右边
        pos = this.findLastPos(nums, target);
        ans[1] = pos;

        return ans[1] - ans[0] + 1;
    }

    private int findFirstPos(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            // 偏左
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

    private int findLastPos(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            // 偏右
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
        Offer53I test = new Offer53I();
        System.out.println(test.search(new int[]{5, 7, 7, 8, 8, 10}, 8));
    }
}
