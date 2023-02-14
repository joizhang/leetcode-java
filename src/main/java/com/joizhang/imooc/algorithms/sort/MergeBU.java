package com.joizhang.imooc.algorithms.sort;

/**
 * 自底向上归并排序。先归并那些微型数组，然后成对归并得到的微型数组。
 */
public interface MergeBU {

    @SuppressWarnings("unchecked")
    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        E[] aux = (E[]) new Comparable[arr.length];
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz * 2) {
                // 对 a[i...i+sz-1] 和 a[i+sz...i+2*sz-1] 进行归并
                Merge.merge(arr, aux, i, i + sz - 1, Math.min(n - 1, i + 2 * sz - 1));
            }
        }
    }

}
