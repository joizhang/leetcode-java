package com.joizhang.lc.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 179. 最大数
 */
public class Q179LargestNumber {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o2 + o1).compareTo(o1 + o2);
            }
        });
        if ("0".equals(strs[0])) return "0";
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    public String largestNumber2(int[] nums) {
        if (nums == null || nums.length == 0) return "";
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        if ("0".equals(strs[0])) return "0";
        StringBuilder res = new StringBuilder();
        for (String str : strs) {
            res.append(str);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int lo, int hi) {
        if (lo >= hi) return;
        int p = partition(strs, lo, hi);
        quickSort(strs, lo, p - 1);
        quickSort(strs, p + 1, hi);
    }

    private int partition(String[] strs, int lo, int hi) {
        int randInt = lo + (int) (Math.random() * (hi - lo + 1));
        swap(strs, lo, randInt);
        String v = strs[lo];
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= hi && (v + strs[i]).compareTo(strs[i] + v) < 0) {
                i++;
            }
            while (j >= lo + 1 && (v + strs[j]).compareTo(strs[j] + v) >= 0) {
                j--;
            }
            if (i >= j) break;
            swap(strs, i, j);
            i++;
            j--;
        }
        swap(strs, lo, j);
        return j;
    }

    private void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    public static void main(String[] args) {
        Q179LargestNumber test = new Q179LargestNumber();
        System.out.println(test.largestNumber(new int[]{10, 2}));
        System.out.println(test.largestNumber(new int[]{3, 30, 34, 5, 9}));

        System.out.println(test.largestNumber2(new int[]{10, 2}));
        System.out.println(test.largestNumber2(new int[]{3, 30, 34, 5, 9}));
    }
}
