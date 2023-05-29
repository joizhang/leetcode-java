package com.joizhang.lcof.math;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 */
public class Offer14II {
    // 快速幂求余
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

    // 循环取余
    public int cuttingRope2(int n) {
        if (n <= 3) return n - 1;
        int b = n % 3, p = 1000000007;
        long ret = 1;
        // 线段被我们分成以3为大小的小线段个数
        int lineNums = n / 3;
        // 从第一段线段开始验算，3的ret次方是否越界。注意是验算lineNums-1次。
        for (int i = 1; i < lineNums; i++) {
            ret = 3 * ret % p;
        }

        if (b == 0) {
            return (int) (ret * 3 % p);
        } else if (b == 1) {
            return (int) (ret * 4 % p);
        } else {
            return (int) (ret * 6 % p);
        }
    }

    public static void main(String[] args) {
        Offer14II test = new Offer14II();
        System.out.println(test.cuttingRope(10));
        System.out.println(test.cuttingRope(120));
    }
}
