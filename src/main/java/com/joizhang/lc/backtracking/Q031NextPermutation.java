package com.joizhang.lc.backtracking;

import java.util.Arrays;

/**
 * 31. 下一个排列
 * [1, 2, 3, 4, 5, 6]
 * [1, 2, 3, 4, 6, 5]
 * [1, 2, 3, 5, 4, 6]
 * [1, 2, 3, 5, 6, 4]
 * [1, 2, 3, 6, 4, 5]
 * [1, 2, 3, 6, 5, 4]
 * [1, 2, 4, 3, 5, 6]
 * [1, 2, 4, 3, 6, 5]
 * [1, 2, 4, 5, 3, 6]
 * [1, 2, 4, 5, 6, 3]
 */
public class Q031NextPermutation {
    /**
     * 举个例子：
     * 比如 nums = [1,2,7,4,3,1]，下一个排列是什么？
     * <p>
     * 我们找到第一个最大索引是 nums[1] = 2
     * <p>
     * 再找到第二个最大索引是 nums[4] = 3
     * <p>
     * 交换，nums = [1,3,7,4,2,1];
     * <p>
     * 翻转，nums = [1,3,1,2,4,7]
     * <p>
     * 作者：powcai
     * 链接：https://leetcode.cn/problems/next-permutation/solution/xia-yi-ge-pai-lie-by-powcai/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int firstIndex = -1;
        // 1. 先找出最大的索引 firstIndex 满足 nums[firstIndex] < nums[firstIndex+1]，如果不存在，就翻转整个数组
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                firstIndex = i;
                break;
            }
        }
        if (firstIndex == -1) {
            reverse(nums, 0, nums.length - 1);
            return;
        }

        // 2. 再找出另一个最大索引 secondIndex 满足 nums[secondIndex] > nums[firstIndex]；
        int secondIndex = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] > nums[firstIndex]) {
                secondIndex = i;
                break;
            }
        }
        // 3. 交换 nums[firstIndex] 和 nums[secondIndex]；
        swap(nums, firstIndex, secondIndex);
        // 4. 最后翻转 nums[firstIndex+1:]。
        reverse(nums, firstIndex + 1, nums.length - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        Q031NextPermutation test = new Q031NextPermutation();
        int[] nums = new int[]{1, 2, 3};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{3, 2, 1};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 1, 5};
        test.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }
}
