package com.joizhang.lcof.math;

/**
 * 剑指 Offer 65. 不用加减乘除做加法
 */
public class Offer65 {
    public int add(int a, int b) {
        while (b != 0) {
            int c = (a & b) << 1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        Offer65 test = new Offer65();
        System.out.println(test.add(1, 1));
    }
}
