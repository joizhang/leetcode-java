package com.joizhang.lc.math;

/**
 * 69. Sqrt(x)
 */
public class Q069SqrtX {
    public int mySqrt(int x) {
        int lo = 0, hi = x;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (mid * mid > x) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Q069SqrtX test = new Q069SqrtX();
        System.out.println(test.mySqrt(4));
        System.out.println(test.mySqrt(8));
    }
}
