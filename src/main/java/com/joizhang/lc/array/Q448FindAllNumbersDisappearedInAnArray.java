package com.joizhang.lc.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. 找到所有数组中消失的数字
 */
public class Q448FindAllNumbersDisappearedInAnArray {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] - 1 != i) {
                int temp = nums[i] - 1;
                if (nums[i] == nums[temp]) {
                    break;
                }
                swap(nums, i, temp);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] - 1 != i) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Q448FindAllNumbersDisappearedInAnArray test = new Q448FindAllNumbersDisappearedInAnArray();
        System.out.println(test.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));
        System.out.println(test.findDisappearedNumbers(new int[]{1, 1}));
    }
}
