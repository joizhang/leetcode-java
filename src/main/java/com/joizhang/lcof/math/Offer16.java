package com.joizhang.lcof.math;

/**
 * 剑指 Offer 16. 数值的整数次方
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) res *= x;
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer16 test = new Offer16();
        System.out.println(test.myPow(2.00000, 10));
        System.out.println(test.myPow(2.10000, 3));
        System.out.println(test.myPow(2.00000, -2));
        System.out.println(test.myPow(1.00000, -2147483648));
    }
}
