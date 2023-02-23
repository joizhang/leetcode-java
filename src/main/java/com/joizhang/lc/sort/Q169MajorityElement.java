package com.joizhang.lc.sort;

/**
 * 169. 多数元素
 */
public class Q169MajorityElement {
    public int majorityElement(int[] nums) {
        if (nums.length <= 2) return nums[0];
        int res = nums[0], count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == res) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                res = nums[i];
                count = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Q169MajorityElement test = new Q169MajorityElement();
        System.out.println(test.majorityElement(new int[]{1, 1}));
        System.out.println(test.majorityElement(new int[]{3, 2, 3}));
        System.out.println(test.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2}));
    }
}
