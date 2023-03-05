package com.joizhang.lc.backtracking;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. 和为 K 的子数组
 */
public class Q560SubArraySumEqualsK {
    // 暴力解法
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // 前缀和
    public int subarraySum2(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int n = nums.length;
        // key：前缀和，value：key 对应的前缀和的个数
        Map<Integer, Integer> preSumFreq = new HashMap<>();
        // 对于下标为 0 的元素，前缀和为 0，个数为 1
        preSumFreq.put(0, 1);

        int preSum = 0;
        int count = 0;
        for (int num : nums) {
            preSum += num;
            // 先获得前缀和为 preSum - k 的个数，加到计数变量里
            if (preSumFreq.containsKey(preSum - k)) {
                count += preSumFreq.get(preSum - k);
            }
            // 然后维护 preSumFreq 的定义
            preSumFreq.put(preSum, preSumFreq.getOrDefault(preSum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        Q560SubArraySumEqualsK test = new Q560SubArraySumEqualsK();
        System.out.println(test.subarraySum(new int[]{1, 1, 1}, 2));
        System.out.println(test.subarraySum(new int[]{1, 2, 3}, 3));
        System.out.println(test.subarraySum(new int[]{1, 2, 1, 2, 1}, 3));
        System.out.println(test.subarraySum(new int[]{1, -1, 0}, 0));
    }
}
