package com.joizhang.lcof.math;

/**
 * 剑指 Offer 44. 数字序列中某一位的数字
 * <a href="https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/solution/mian-shi-ti-44-shu-zi-xu-lie-zhong-mou-yi-wei-de-6/">...</a>
 */
public class Offer44 {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

    public static void main(String[] args) {
        Offer44 test = new Offer44();
        System.out.println(test.findNthDigit(3));
        System.out.println(test.findNthDigit(11));
    }
}
