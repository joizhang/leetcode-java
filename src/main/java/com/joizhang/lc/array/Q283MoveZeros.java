package com.joizhang.lc.array;

import java.util.Arrays;

/**
 * 283. 移动零
 */
public class Q283MoveZeros {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != j) {
                    int temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                }
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Q283MoveZeros test = new Q283MoveZeros();
        int[] nums = {0, 1, 0, 3, 12};
        test.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
