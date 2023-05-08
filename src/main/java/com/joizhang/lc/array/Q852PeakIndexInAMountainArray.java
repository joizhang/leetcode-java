package com.joizhang.lc.array;

public class Q852PeakIndexInAMountainArray {

    public int peakIndexInMountainArray(int[] arr) {
        int lo = 1, hi = arr.length - 2;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid - 1] < arr[mid] && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (arr[mid - 1] < arr[mid] && arr[mid] < arr[mid + 1]) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Q852PeakIndexInAMountainArray test = new Q852PeakIndexInAMountainArray();
        System.out.println(test.peakIndexInMountainArray(new int[]{24, 69, 100, 99, 79, 78, 67, 36, 26, 19}));
    }
}
