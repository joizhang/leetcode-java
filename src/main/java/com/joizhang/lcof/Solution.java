package com.joizhang.lcof;

public class Solution {

    public int missingNumber(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == mid) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
    }
}
