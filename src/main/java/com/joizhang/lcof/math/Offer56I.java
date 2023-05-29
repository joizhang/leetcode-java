package com.joizhang.lcof.math;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 参考：<a href="https://leetcode.cn/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/liang-liao-wei-yun-suan-yi-huo-shuang-bai-guo-by-1/">...</a>
 */
public class Offer56I {
    public int[] singleNumbers(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum ^= num;
        }
        int first = 1;
        // 通过与运算找到result第一个不为0的首位
        while ((sum & first) == 0) {
            first <<= 1;
        }
        int x = 0, y = 0;
        for (int num : nums) {
            if ((num & first) != 0) {
                x ^= num;
            } else {
                y ^= num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Offer56I test = new Offer56I();
        System.out.println(Arrays.toString(test.singleNumbers(new int[]{4, 4, 6, 1})));
    }
}
