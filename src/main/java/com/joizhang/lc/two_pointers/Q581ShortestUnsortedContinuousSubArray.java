package com.joizhang.lc.two_pointers;

/**
 * 581. 最短无序连续子数组
 */
public class Q581ShortestUnsortedContinuousSubArray {
    // 我们可以假设把这个数组分成三段，左段和右段是标准的升序数组，
    // 中段数组虽是无序的，但满足最小值大于左段的最大值，最大值小
    // 于右段的最小值。
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int min = nums[n - 1], max = nums[0];
        int begin = 0, end = -1;

        for (int i = 0; i < n; i++) {
            // 从左到右维持最大值，寻找右边界end
            if (nums[i] < max) {
                end = i;
            } else {
                max = nums[i];
            }

            // //从右到左维持最小值，寻找左边界begin
            if (nums[n - i - 1] > min) {
                begin = n - i - 1;
            } else {
                min = nums[n - i - 1];
            }
        }
        return end - begin + 1;
    }

    public static void main(String[] args) {
        Q581ShortestUnsortedContinuousSubArray test = new Q581ShortestUnsortedContinuousSubArray();
        System.out.println(test.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15}));
    }
}
