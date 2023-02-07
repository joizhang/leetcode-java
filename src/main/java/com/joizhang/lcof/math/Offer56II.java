package com.joizhang.lcof.math;

/**
 * 剑指 Offer 56 - II. 数组中数字出现的次数 II
 */
public class Offer56II {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                count[i] += num & 1;
                num >>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= count[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer56II test = new Offer56II();
        System.out.println(test.singleNumber(new int[]{3, 5, 3, 3}));
    }
}
