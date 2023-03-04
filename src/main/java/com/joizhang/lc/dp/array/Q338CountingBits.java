package com.joizhang.lc.dp.array;

import java.util.Arrays;

/**
 * 338. 比特位计数
 */
public class Q338CountingBits {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            int num = i;
            while (num != 0) {
                ans[i] += (num & 1);
                num >>= 1;
            }
        }
        return ans;
    }

    public int[] countBits2(int n) {
        int[] ans = new int[n + 1];
        ans[0] = 0;
        for (int i = 0; i < n + 1; i++) {
            if (i % 2 == 1) {
                // 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
                ans[i] = ans[i - 1] + 1;
            } else {
                // 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
                // 因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
                ans[i] = ans[i / 2];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q338CountingBits test = new Q338CountingBits();
        System.out.println(Arrays.toString(test.countBits(2)));
        System.out.println(Arrays.toString(test.countBits(5)));

        System.out.println(Arrays.toString(test.countBits2(2)));
        System.out.println(Arrays.toString(test.countBits2(5)));
    }
}
