package com.joizhang.lcof.binary_search;

/**
 * 剑指 Offer 11. 旋转数组的最小数字
 */
public class Offer11 {
    public int minArray(int[] numbers) {
        int lo = 0;
        int hi = numbers.length - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > numbers[hi]) {
                lo = mid + 1;
            } else if (numbers[mid] < numbers[hi]) {
                hi = mid;
            } else {
                hi -= 1;
            }
        }
        return numbers[lo];
    }

    public static void main(String[] args) {
        Offer11 test = new Offer11();
        System.out.println(test.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(test.minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
