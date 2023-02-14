package com.joizhang.imooc.algorithms.sort;

/**
 * 冒泡排序
 */
public interface Bubble {

    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        for (int i = n - 1; i >= 0; i--) {
            boolean swapped = false;
            for (int j = 0; j < i; j++) {
                if (Sorts.less(arr[j + 1], arr[j])) {
                    Sorts.exchange(arr, j, j + 1);
                    swapped = true;
                }
            }
            if (!swapped) break;
        }
    }

}
