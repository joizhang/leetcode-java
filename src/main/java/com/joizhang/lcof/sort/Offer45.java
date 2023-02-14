package com.joizhang.lcof.sort;

import java.util.Arrays;

/**
 * 面试题45. 把数组排成最小的数
 * <p>x = "3"，y = "30"，330 > 303，> 是整数判断
 * <p>"30" 小于 "3"，"小于"意味着"30"应该排在"3"的前面
 */
public class Offer45 {
    // Java 内置排序
    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    // 快速排序
    public String minNumber2(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] strs, int l, int r) {
        if (l >= r) return;
        int p = partition(strs, l, r);
        quickSort(strs, l, p - 1);
        quickSort(strs, p + 1, r);
    }

    private int partition(String[] strs, int l, int r) {
        int randInt = l + (int) (Math.random() * (r - l + 1));
        swap(strs, l, randInt);
        String v = strs[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && (strs[i] + v).compareTo(v + strs[i]) < 0) {
                i++;
            }
            while (j >= l + 1 && (strs[j] + v).compareTo(v + strs[j]) >= 0) {
                j--;
            }
            if (i >= j) break;
            swap(strs, i, j);
            i++;
            j--;
        }
        swap(strs, l, j);
        return j;
    }

    private void swap(String[] strs, int i, int j) {
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }

    // 归并排序
    public String minNumber3(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        String[] aux = new String[nums.length];
        mergeSort(strs, aux, 0, strs.length - 1);
        StringBuilder res = new StringBuilder();
        for (String s : strs) {
            res.append(s);
        }
        return res.toString();
    }

    private void mergeSort(String[] strs, String[] aux, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;
        mergeSort(strs, aux, l, mid);
        mergeSort(strs, aux, mid + 1, r);
        merge(strs, aux, l, mid, r);
    }

    private void merge(String[] strs, String[] aux, int l, int mid, int r) {
        if (r + 1 - l >= 0) System.arraycopy(strs, l, aux, l, r + 1 - l);
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                strs[k] = aux[j];
                j++;
            } else if (j > r) {
                strs[k] = aux[i];
                i++;
            } else if ((aux[i] + aux[j]).compareTo(aux[j] + aux[i]) <= 0) {
                strs[k] = aux[i];
                i++;
            } else {
                strs[k] = aux[j];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        Offer45 test = new Offer45();
        System.out.println(test.minNumber(new int[]{10, 2}));
        System.out.println(test.minNumber(new int[]{3, 30, 34, 5, 9}));

        System.out.println(test.minNumber2(new int[]{10, 2}));
        System.out.println(test.minNumber2(new int[]{3, 30, 34, 5, 9}));

        System.out.println(test.minNumber3(new int[]{10, 2}));
        System.out.println(test.minNumber3(new int[]{3, 30, 34, 5, 9}));
    }
}
