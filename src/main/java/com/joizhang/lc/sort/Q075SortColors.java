package com.joizhang.lc.sort;

import java.util.Arrays;

/**
 * 75. 颜色分类
 */
public class Q075SortColors {
    public void sortColors(int[] nums) {
        // [0...zero] = 0
        int zero = -1;
        // [two...n] = 2
        int two = nums.length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 0) {
                swap(nums, i, ++zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                // 注意当 nums[i] == 2 时不能i++
                swap(nums, i, --two);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q075SortColors test = new Q075SortColors();
        int[] nums = new int[]{2, 0, 2, 1, 1, 0};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{2, 0, 1};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));

        nums = new int[]{1, 2, 0};
        test.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
