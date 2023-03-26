package com.joizhang.lc.two_pointers;

import java.util.Arrays;

public class Q189RotateArray {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotateBetween(nums, 0, n - k - 1);
        rotateBetween(nums, n - k, n - 1);
        rotateBetween(nums, 0, n - 1);
    }

    private void rotateBetween(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Q189RotateArray test = new Q189RotateArray();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        test.rotate(nums, 3);
        System.out.println(Arrays.toString(nums));
    }
}
