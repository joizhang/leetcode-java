package com.joizhang.lc.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 217. 存在重复元素
 */
public class Q217ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    public boolean containsDuplicate2(int[] nums) {
        if (nums == null || nums.length < 2) return false;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) return true;
        }
        return false;
    }
}
