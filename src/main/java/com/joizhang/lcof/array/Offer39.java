package com.joizhang.lcof.array;

/**
 * 剑指 Offer 39. 数组中出现次数超过一半的数字
 */
public class Offer39 {
    // 1. 哈希表统计法

    // 2. 数组排序法

    // 3. 摩尔投票法：核心理念为票数正负抵消
    public int majorityElement(int[] nums) {
        int count = 1, res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Offer39 test = new Offer39();
        System.out.println(test.majorityElement(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }
}
