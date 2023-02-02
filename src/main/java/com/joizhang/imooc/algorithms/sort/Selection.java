package com.joizhang.imooc.algorithms.sort;

/**
 * 选择排序
 */
public interface Selection {
    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // 寻找[i, n)区间中的最小值
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (Sorts.less(arr[j], arr[minIndex])) {
                    minIndex = j;
                }
            }
            Sorts.exchange(arr, i, minIndex);
        }
    }
}
