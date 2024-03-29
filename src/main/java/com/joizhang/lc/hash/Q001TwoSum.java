package com.joizhang.lc.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 */
public class Q001TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num)) {
                return new int[]{map.get(num), i};

            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }

    public static void main(String[] args) {
        Q001TwoSum test = new Q001TwoSum();
        System.out.println(Arrays.toString(test.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{3, 2, 4}, 6)));
        System.out.println(Arrays.toString(test.twoSum(new int[]{3, 3}, 6)));
    }
}
