package com.joizhang.lcof.array;

import java.util.Arrays;

/**
 * 剑指 Offer 66. 构建乘积数组
 */
public class Offer66 {
    public int[] constructArr(int[] a) {
        int len = a.length;
        if (len == 0) return new int[0];
        int[] b = new int[len];
        b[0] = 1;
        for (int i = 1; i < len; i++) {
            b[i] = b[i - 1] * a[i - 1]; // 下三角
        }
        int temp = 1;
        for (int i = len - 2; i >= 0; i--) {
            temp *= a[i + 1]; // 上三角
            b[i] *= temp; // 下三角 * 上三角
        }
        return b;
    }

    public static void main(String[] args) {
        Offer66 test = new Offer66();
        System.out.println(Arrays.toString(test.constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
