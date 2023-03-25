package com.joizhang.lc.array;

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

    public static void main(String[] args) {
        Q287FindTheDuplicateNumber test = new Q287FindTheDuplicateNumber();
        System.out.println(test.findDuplicate(new int[]{1, 3, 4, 2, 2}));
        System.out.println(test.findDuplicate(new int[]{3, 1, 3, 4, 2}));
    }
}
