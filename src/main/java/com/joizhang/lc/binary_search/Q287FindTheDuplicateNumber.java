package com.joizhang.lc.binary_search;

/**
 * 287. Find the Duplicate Number
 */
public class Q287FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == i + 1) {
                i++;
            } else {
                if (nums[i] == nums[nums[i] - 1]) {
                    return nums[i];
                } else {
                    int temp = nums[i];
                    nums[i] = nums[temp - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // nums是一个包含n + 1个整数的数组，数字都在 [1, n] 范围内（包括 1 和 n）
        int len = nums.length; // len = n + 1
        // 在 [1..n] 查找 nums 中重复的元素
        int lo = 1, hi = len - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            // nums 中小于等于 mid 的元素的个数
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        Q287FindTheDuplicateNumber test = new Q287FindTheDuplicateNumber();
        System.out.println(test.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(test.findDuplicate(new int[]{3, 1, 3, 4, 2}));

        System.out.println(test.findDuplicate2(new int[]{1, 3, 4, 2, 2}));
        System.out.println(test.findDuplicate2(new int[]{3, 1, 3, 4, 2}));
    }
}
