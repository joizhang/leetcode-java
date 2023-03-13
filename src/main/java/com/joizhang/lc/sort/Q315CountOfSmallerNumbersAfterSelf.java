package com.joizhang.lc.sort;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Q315CountOfSmallerNumbersAfterSelf {
    private static class ArrayValWithOrigIdx {
        int val;
        int originalIdx;

        public ArrayValWithOrigIdx(int val, int originalIdx) {
            this.val = val;
            this.originalIdx = originalIdx;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        if (nums == null || nums.length == 0) return new ArrayList<>();
        int n = nums.length;
        int[] result = new int[n];

        ArrayValWithOrigIdx[] newNums = new ArrayValWithOrigIdx[n];
        for (int i = 0; i < n; i++) {
            newNums[i] = new ArrayValWithOrigIdx(nums[i], i);
        }

        mergeSortAndCount(newNums, 0, n - 1, result);

        List<Integer> resultList = new ArrayList<>();
        for (int i : result) {
            resultList.add(i);
        }
        return resultList;
    }

    private void mergeSortAndCount(ArrayValWithOrigIdx[] newNums, int start, int end, int[] result) {
        if (start >= end) return;

        int mid = start + (end - start) / 2;
        mergeSortAndCount(newNums, start, mid, result);
        mergeSortAndCount(newNums, mid + 1, end, result);

        int leftPos = start;
        int rightPos = mid + 1;
        List<ArrayValWithOrigIdx> merged = new ArrayList<>();
        int numElemsRightArrayLessThanLeftArray = 0;
        while (leftPos < mid + 1 && rightPos <= end) {
            if (newNums[leftPos].val > newNums[rightPos].val) {
                // this code block is exactly what the problem is asking us for:
                // a number from the right side of the original input array, is smaller
                // than a number from the left side
                //
                // within this code block,
                // nums[rightPos] is smaller than the start of the left sub-array.
                // Since left sub-array is already sorted,
                // nums[rightPos] must also be smaller than the entire remaining left sub-array
                ++numElemsRightArrayLessThanLeftArray;

                // continue with normal merge sort, merge
                merged.add(newNums[rightPos]);
                ++rightPos;
            } else {
                // a number from left side of array, is smaller than a number from
                // right side of array
                result[newNums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;

                // Continue with normal merge sort
                merged.add(newNums[leftPos]);
                ++leftPos;
            }
        }

        // part of normal merge sort, if either left or right sub-array is not empty,
        // move all remaining elements into merged result
        while (leftPos < mid + 1) {
            result[newNums[leftPos].originalIdx] += numElemsRightArrayLessThanLeftArray;
            merged.add(newNums[leftPos]);
            ++leftPos;
        }
        while (rightPos <= end) {
            merged.add(newNums[rightPos]);
            ++rightPos;
        }

        // part of normal merge sort
        // copy back merged result into array
        int pos = start;
        for (ArrayValWithOrigIdx m : merged) {
            newNums[pos] = m;
            ++pos;
        }
    }
}
