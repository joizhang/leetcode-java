package com.joizhang.lc.math;

/**
 * 461. 汉明距离
 */
public class Q461HammingDistance {
    public int hammingDistance(int x, int y) {
        int ans = 0;
        while (x != 0 || y != 0) {
            if ((x & 1) != (y & 1)) {
                ans ++;
            }
            x >>= 1;
            y >>= 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Q461HammingDistance test = new Q461HammingDistance();
        System.out.println(test.hammingDistance(1, 4));
        System.out.println(test.hammingDistance(3, 1));
    }
}
