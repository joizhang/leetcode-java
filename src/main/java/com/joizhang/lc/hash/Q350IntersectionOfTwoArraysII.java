package com.joizhang.lc.hash;

import java.util.*;

/**
 * 350. 两个数组的交集 II
 * 输出结果中的每个元素并不一定是唯一的
 */
public class Q350IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0) return new int[0];
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                res.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        return res.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Q350IntersectionOfTwoArraysII test = new Q350IntersectionOfTwoArraysII();
        System.out.println(Arrays.toString(test.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(test.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4})));
    }
}
