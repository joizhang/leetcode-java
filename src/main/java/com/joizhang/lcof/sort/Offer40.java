package com.joizhang.lcof.sort;

import java.util.Arrays;

/**
 * 剑指 Offer 40. 最小的k个数
 */
public class Offer40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr == null || arr.length == 0) return new int[0];
        int[] res = new int[k];
        Arrays.sort(arr);
        System.arraycopy(arr, 0, res, 0, k);
        return res;
    }

    public static void main(String[] args) {
        Offer40 test = new Offer40();
        System.out.println(Arrays.toString(test.getLeastNumbers(new int[]{3, 2, 1}, 2)));
        System.out.println(Arrays.toString(test.getLeastNumbers(new int[]{0, 1, 2, 1}, 1)));
    }
}
