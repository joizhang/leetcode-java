package com.joizhang.lc.array;

public class Q137SingleNumberII {
    public int singleNumber(int[] nums) {
        // 记录所有数字的各二进制位的1的出现次数
        int[] counts = new int[32];
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for (int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }

    public static void main(String[] args) {
        Q137SingleNumberII test = new Q137SingleNumberII();
        System.out.println(test.singleNumber(new int[]{2, 2, 3, 2}));
        System.out.println(test.singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
