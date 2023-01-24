package com.joizhang.lcof.binary_search;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 */
public class Offer53II {
    public int missingNumber(int[] nums) {
        // 一定有数字缺失
        int n = nums.length + 1;
        for (int i = 0; i < nums.length; i++) {
            if (i != nums[i]) {
                return i;
            }
        }
        return n - 1;
    }

    public int missingNumber2(int[] nums) {
        int lo = 0;
        int hi = nums.length;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (mid == nums[mid]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Offer53II test = new Offer53II();
        System.out.println(test.missingNumber(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        System.out.println(test.missingNumber2(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 9}));
        System.out.println(test.missingNumber(new int[]{0}));
        System.out.println(test.missingNumber2(new int[]{0}));
    }
}
