package com.joizhang.lc.sort;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 */
public class Q088MergeSortedArray {
    // 类似快速排序的partition
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1, j = n - 1;
        for (int k = m + n - 1; k >= 0; k--) {
            if (i < 0) {
                nums1[k] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[k] = nums1[i];
                i--;
            } else if (nums1[i] >= nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
        }
    }

    public static void main(String[] args) {
        Q088MergeSortedArray test = new Q088MergeSortedArray();
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};
        test.merge(nums1, 3,nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
