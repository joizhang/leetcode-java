package com.joizhang.lcof.math;

/**
 * 剑指 Offer 62. 圆圈中最后剩下的数字
 * <a href="https://leetcode.cn/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/javajie-jue-yue-se-fu-huan-wen-ti-gao-su-ni-wei-sh/">...</a>
 */
public class Offer62 {
    public int lastRemaining(int n, int m) {
        int x = 0;
        for (int i = 2; i <= n; i++) {
            x = (x + m) % i;
        }
        return x;
    }

    public static void main(String[] args) {
        Offer62 test = new Offer62();
        System.out.println(test.lastRemaining(5, 3));
    }
}
