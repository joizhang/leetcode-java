package com.joizhang.lcof.math;

/**
 * 剑指 Offer 15. 二进制中1的个数
 */
public class Offer15 {
    // >> 带符号右移。正数右移高位补0，负数右移高位补1
    // >>> 无符号右移。无论是正数还是负数，高位通通补0。
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res ++;
            }
            // 有负数，需要使用无符号右移
            n >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer15 test = new Offer15();
        System.out.println(test.hammingWeight(11));
        System.out.println(test.hammingWeight(128));
        System.out.println(test.hammingWeight(-3));
    }
}
