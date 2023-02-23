package com.joizhang.lc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 四数之和
 */
public class Q018FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if (nums == null || nums.length < 4) return new ArrayList<>();
        Arrays.sort(nums);
        return nSum(nums, target, 4, 0);
    }

    private List<List<Integer>> nSum(int[] nums, long target, int n, int index) {
        List<List<Integer>> ans = new ArrayList<>();
        if (index >= nums.length) {
            return ans;
        }
        if (n == 2) {
            int i = index, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[j]));
                    // 跳过重复元素
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    // 注意还需要再跳一次
                    i++;
                    j--;
                } else if (sum < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            int i = index;
            while (i < (nums.length - n + 1)) {
                List<List<Integer>> temp = nSum(nums, target - nums[i], n - 1, i + 1);
                if (!temp.isEmpty()) {
                    for (List<Integer> a : temp) {
                        List<Integer> b = new ArrayList<>();
                        b.add(nums[i]);
                        b.addAll(a);
                        ans.add(b);
                    }
                }
                // 跳过重复元素
                while (i < (nums.length - 1) && nums[i] == nums[i + 1]) {
                    i++;
                }
                i++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q018FourSum test = new Q018FourSum();
        System.out.println(test.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
        System.out.println(test.fourSum(new int[]{2, 2, 2, 2, 2}, 8));
        System.out.println(test.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296));
    }
}
