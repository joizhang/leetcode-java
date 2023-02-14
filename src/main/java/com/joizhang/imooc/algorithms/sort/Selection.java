package com.joizhang.imooc.algorithms.sort;

/**
 * 选择排序。选择排序需要 ~N2/2 次比较和 ~N 次交换，它的运行时间与输入无关，
 * 这个特点使得它对一个已经排序的数组也需要这么多的比较和交换操作。
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
