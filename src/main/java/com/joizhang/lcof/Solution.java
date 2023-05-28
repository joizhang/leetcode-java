package com.joizhang.lcof;

public class Solution {

    public int minArray(int[] numbers) {
        int lo = 0, hi = numbers.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (numbers[mid] > numbers[hi]) {
                lo = mid + 1;
            } else if (numbers[mid] < numbers[hi]) {
                hi = mid;
            } else {
                hi -= 1;
            }
        }
        return numbers[lo];
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(test.minArray(new int[]{2, 2, 2, 0, 1}));
    }
}
