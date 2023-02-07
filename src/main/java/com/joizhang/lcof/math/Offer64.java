package com.joizhang.lcof.math;

/**
 * 剑指 Offer 64. 求1+2+…+n
 */
public class Offer64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }

    public static void main(String[] args) {
        Offer64 test = new Offer64();
        System.out.println(test.sumNums(9));
    }
}
