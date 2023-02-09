package com.joizhang.lcof.math;

/**
 * 剑指 Offer 14- I. 剪绳子
 */
public class Offer14I {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int a = n / 3, b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        } else if (b == 1) {
            return (int) Math.pow(3, a - 1) * 2 * 2;
        } else {
            return (int) Math.pow(3, a) * 2;
        }
    }

    public static void main(String[] args) {
        Offer14I test = new Offer14I();
        System.out.println(test.cuttingRope(2));
        System.out.println(test.cuttingRope(10));
    }
}
