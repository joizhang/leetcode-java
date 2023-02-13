package com.joizhang.lc.hash;

import java.util.*;

/**
 * 349. 两个数组的交集
 */
public class Q349IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        for (int num : nums2) {
            if (set.contains(num)) {
                res.add(num);
                set.remove(num);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Q349IntersectionOfTwoArrays test = new Q349IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(test.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(test.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
