package com.joizhang.imooc.algorithms.sort;

import java.util.Random;

/**
 * 排序工具
 */
public interface Sorts {

    Random RANDOM = new Random(47);

    /**
     * 排序类型
     */
    enum SortType {
        /**
         * 冒泡排序
         */
        BUBBLE,
        /**
         * 选择排序
         */
        SELECTION,
        /**
         * 插入排序
         */
        INSERTION,
        /**
         * 希尔排序
         */
        SHELL,
        /**
         * 归并排序
         */
        MERGE,
        /**
         * 快速排序
         */
        QUICK,
        /**
         * 堆排序
         */
        HEAP,
    }

    static <E extends Comparable<E>> boolean less(E v, E w) {
        return v.compareTo(w) < 0;
    }

    static <E extends Comparable<E>> void exchange(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static <E extends Comparable<E>> void show(E[] arr) {
        for (E num: arr) {
            System.out.println(num + " ");
        }
        System.out.println();
    }

    static <E extends Comparable<E>> boolean isSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i], arr[i - 1])) {
                return false;
            }
        }
        return true;
    }

    static <E extends Comparable<E>> boolean isDescSorted(E[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (less(arr[i-1], arr[i])) {
                return false;
            }
        }
        return true;
    }

    static Integer[] generateRandomArray(int n, int rangeL, int rangeR) {
        assert rangeL <= rangeR;
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = RANDOM.nextInt(rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    static Integer[] generateNearlyOrderedArray(int n, int swapTimes) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < swapTimes; i++) {
            Sorts.exchange(arr, i, RANDOM.nextInt(swapTimes));
        }
        return arr;
    }

    static <E extends Comparable<E>> void insertionSort(E[] arr, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            E e = arr[i];
            int j;
            for (j = i; j > l && Sorts.less(e, arr[j - 1]); j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }
}
