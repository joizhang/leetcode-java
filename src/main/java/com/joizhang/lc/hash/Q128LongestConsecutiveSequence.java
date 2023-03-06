package com.joizhang.lc.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 */
public class Q128LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        // 用哈希表存储每个端点值对应连续区间的长度
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;
        for (int num : nums) {
            if (!map.containsKey(num)) {
                int left = map.getOrDefault(num - 1, 0);
                int right = map.getOrDefault(num + 1, 0);
                int curLength = left + right + 1;
                maxLength = Math.max(maxLength, curLength);
                map.put(num, curLength);
                map.put(num - left, curLength);
                map.put(num + right, curLength);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        Q128LongestConsecutiveSequence test = new Q128LongestConsecutiveSequence();
        System.out.println(test.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(test.longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
    }
}
