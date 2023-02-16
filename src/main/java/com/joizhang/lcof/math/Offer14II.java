package com.joizhang.lcof.math;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */
public class Offer14II {
    public int cuttingRope(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long rem = 1, x = 3;
        for (int  a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                rem = (rem * x) % p;
            }
            x = (x * x) % p;
        }
        if (b == 0) return (int) (rem * 3 % p);
        if (b == 1) return (int) (rem * 4 % p);
        return (int) (rem * 6 % p);
    }

    public static void main(String[] args) {
        Offer14II test = new Offer14II();
        System.out.println(test.cuttingRope(10));
        System.out.println(test.cuttingRope(120));
    }
}
