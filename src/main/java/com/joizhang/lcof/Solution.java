package com.joizhang.lcof;

public class Solution {

    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return 0;
        int posFirst = findFirstPos(nums, target);
        if (posFirst == -1) return 0;
        int posLast = findLastPos(nums, target);
        return posLast - posFirst + 1;
    }

    private int findLastPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (target < nums[mid]) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    private int findFirstPos(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (target > nums[mid]) {
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

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.search(new int[]{5,7,7,8,8,10}, 8));
        System.out.println(test.search(new int[]{5,7,7,8,8,10}, 7));
        System.out.println(test.search(new int[]{5,7,7,8,8,10}, 6));
    }
}
