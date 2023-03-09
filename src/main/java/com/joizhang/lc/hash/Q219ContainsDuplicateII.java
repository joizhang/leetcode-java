package com.joizhang.lc.hash;

import java.util.*;

/**
 * 219. Contains Duplicate II
 */
public class Q219ContainsDuplicateII {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        Q219ContainsDuplicateII test = new Q219ContainsDuplicateII();
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(test.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
