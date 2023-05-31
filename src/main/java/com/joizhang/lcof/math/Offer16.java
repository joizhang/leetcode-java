package com.joizhang.lcof.math;

/**
 * 剑指 Offer 16. 数值的整数次方
 * <p>
 * 我们在计算一个数的多次幂时，可以先判断其幂次的奇偶性，然后：
 * <p>
 * 如果幂次为偶直接 base(底数) 作平方，power(幂次) 除以2
 * <p>
 * 如果幂次为奇则底数平方，幂次整除于2然后再多乘一次底数
 */
public class Offer16 {
    public double myPow(double x, int n) {
        if (x == 0) return 0;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        return calc(x, b);
    }

    private double calc(double base, long power) {
        double res = 1.0;
        while (power > 0) {
            //两种情况会进入if语句：
            //1.幂次若为奇数，提前多乘一次x
            //2.当幂次除到1，把x赋值给res
            if ((power & 1) == 1) {
                res *= base;
            }
            power >>= 1;
            base *= base;
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
