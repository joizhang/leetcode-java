package com.joizhang.lcof.math;

/**
 *
 */
public class Offer15 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                res ++;
            }
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
