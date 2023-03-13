package com.joizhang.lc.array;

/**
 * 41. First Missing Positive
 */
public class Q041FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return n + 1;
    }

    private void swap(int[] nums, int i, int j) {
        nums[i] ^= nums[j];
        nums[j] ^= nums[i];
        nums[i] ^= nums[j];
    }

    public static void main(String[] args) {
        Q041FirstMissingPositive test = new Q041FirstMissingPositive();
        System.out.println(test.firstMissingPositive(new int[]{1, 2, 0}));
        System.out.println(test.firstMissingPositive(new int[]{3, 4, -1, 1}));
        System.out.println(test.firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
    }
}
