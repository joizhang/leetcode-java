package com.joizhang.lc.sort;

import java.util.Arrays;

/**
 * 16. 最接近的三数之和
 */
public class Q0163SumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length < 3) return -1;
        Arrays.sort(nums);
        int ans = 0;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == target) {
                    return sum;
                }
                if (Math.abs(sum - target) < closest) {
                    closest = Math.abs(sum - target);
                    ans = sum;
                }
                if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Q0163SumClosest test = new Q0163SumClosest();
        System.out.println(test.threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        System.out.println(test.threeSumClosest(new int[]{0, 0, 0}, 1));
    }
}
