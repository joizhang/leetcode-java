package com.joizhang.lcof.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Offer57 {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(target - num)) {
                return new int[]{target - num, num};
            }
            set.add(num);
        }
        return new int[]{0, 0};
    }

    public int[] twoSum2(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            if (sum < target) {
                lo++;
            } else if (sum > target) {
                hi--;
            } else {
                return new int[]{nums[lo], nums[hi]};
            }
        }
        return new int[2];
    }

    public static void main(String[] args) {
        Offer57 test = new Offer57();
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(test.twoSum2(new int[]{2, 7, 11, 15}, 9)));
    }
}
