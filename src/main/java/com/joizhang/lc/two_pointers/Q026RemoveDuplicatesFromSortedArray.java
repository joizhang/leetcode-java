package com.joizhang.lc.two_pointers;

/**
 * 26. Remove Duplicates from Sorted Array
 */
public class Q026RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != nums[i + 1]) {
                nums[++j] = nums[i + 1];
            }
        }
        return j + 1;
    }

    public static void main(String[] args) {
        Q026RemoveDuplicatesFromSortedArray test = new Q026RemoveDuplicatesFromSortedArray();
        System.out.println(test.removeDuplicates(new int[]{1, 1, 2}));
        System.out.println(test.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));
    }
}
