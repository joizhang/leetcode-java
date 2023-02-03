package com.joizhang.lcof.dp.array;

/**
 * 剑指 Offer 10- I. 斐波那契数列
 */
public class Offer10I {
    public int fib(int n) {
        if (n <= 1) return n;
        int[] nums = new int[]{0, 1};
        for (int i = 2; i <= n; i++) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = (temp + nums[1])  % 1000000007;
        }
        return nums[1];
    }

    public static void main(String[] args) {
        Offer10I test = new Offer10I();
        System.out.println(test.fib(5));
        System.out.println(test.fib(45));
        System.out.println(test.fib(48));
    }
}
