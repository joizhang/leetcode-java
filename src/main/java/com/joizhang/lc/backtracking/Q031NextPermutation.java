package com.joizhang.lc.backtracking;

import java.util.Arrays;

/**
 * 31. 下一个排列
 */
public class Q031NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }

        swap(nums, firstIndex, secondIndex);
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Q031NextPermutation test = new Q031NextPermutation();
        int[] nums = new int[]{1, 2, 3};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 2, 1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 1, 5};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
