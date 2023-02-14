package com.joizhang.lcof.sort;

import java.util.Arrays;

/**
 * 面试题61. 扑克牌中的顺子
 */
public class Offer61 {
    public boolean isStraight(int[] nums) {
        assert nums.length == 5;
        Arrays.sort(nums);
        int joker = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == 0) {
                joker++;
            } else if (nums[i] == nums[i + 1]) {
                return false;
            }
        }
        return nums[4] - nums[joker] < 5;
    }

    public static void main(String[] args) {
        Offer61 test = new Offer61();
        System.out.println(test.isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(test.isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(test.isStraight(new int[]{0, 0, 2, 2, 5}));
        System.out.println(test.isStraight(new int[]{0, 0, 8, 5, 4}));
    }
}
