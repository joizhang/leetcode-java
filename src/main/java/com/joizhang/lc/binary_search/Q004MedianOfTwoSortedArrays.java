package com.joizhang.lc.binary_search;

/**
 * 4. 寻找两个正序数组的中位数
 */
public class Q004MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int idx1 = 0, idx2 = 0;
        int med1 = 0, med2 = 0;
        int len = nums1.length + nums2.length;
        for (int i = 0; i < len / 2 + 1; i++) {
            med1 = med2;
            if (idx1 == nums1.length) {
                med2 = nums2[idx2];
                idx2++;
            } else if (idx2 == nums2.length) {
                med2 = nums1[idx1];
                idx1++;
            } else if (nums1[idx1] < nums2[idx2]) {
                med2 = nums1[idx1];
                idx1++;
            } else {
                med2 = nums2[idx2];
                idx2++;
            }
        }

        if (len % 2 == 0) {
            return (med1 + med2) / 2.0;
        }
        return med2;
    }

    public static void main(String[] args) {
        Q004MedianOfTwoSortedArrays test = new Q004MedianOfTwoSortedArrays();
        System.out.println(test.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        System.out.println(test.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
        System.out.println(test.findMedianSortedArrays(new int[]{}, new int[]{1}));
    }
}
