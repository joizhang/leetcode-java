package com.joizhang.lc.array;

import java.util.Arrays;

public class Q1470ShuffleTheArray {

    public int[] shuffle(int[] nums, int n) {
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; i ++) {
            ans[2 * i] = nums[i];
            ans[2 * i + 1] = nums[i + n];
        }
        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q1470ShuffleTheArray test = new Q1470ShuffleTheArray();
        System.out.println(Arrays.toString(test.shuffle(new int[]{2, 5, 1, 3, 4, 7}, 3)));
        System.out.println(Arrays.toString(test.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4)));
        System.out.println(Arrays.toString(test.shuffle(new int[]{1,1,2,2}, 2)));
    }
}
