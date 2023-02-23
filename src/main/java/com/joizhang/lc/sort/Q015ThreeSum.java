package com.joizhang.lc.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 三数之和
 */
public class Q015ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) return new ArrayList<>();
        Arrays.sort(nums);
        // 三数之和等于0
        return nSum(nums, 0, 3, 0);
    }

    private List<List<Integer>> nSum(int[] nums, int target, int n, int index) {
        List<List<Integer>> ans = new ArrayList<>();
        if (index == nums.length) {
            return ans;
        }
        if (n == 2) {
            int i = index, j = nums.length - 1;
            while (i < j) {
                int sum = nums[i] + nums[j];
                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
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
            // 将n-sum转化为2-sum
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
        Q015ThreeSum test = new Q015ThreeSum();
        System.out.println(test.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
