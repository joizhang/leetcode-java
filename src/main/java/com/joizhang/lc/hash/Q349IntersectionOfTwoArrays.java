package com.joizhang.lc.hash;

import java.util.*;

/**
 * 349. 两个数组的交集
 */
public class Q349IntersectionOfTwoArrays {
    // 方法一：Set
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

    //方法二：排序+双指针
    public int[] intersection2(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        Set<Integer> res = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res.stream().mapToInt(k -> k).toArray();
    }

    public static void main(String[] args) {
        Q349IntersectionOfTwoArrays test = new Q349IntersectionOfTwoArrays();
        System.out.println(Arrays.toString(test.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(test.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));

        System.out.println(Arrays.toString(test.intersection2(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(test.intersection2(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
