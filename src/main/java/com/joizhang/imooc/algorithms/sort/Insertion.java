package com.joizhang.imooc.algorithms.sort;

/**
 * 插入排序，适用于近乎有序的数组
 */
public interface Insertion {

    static <E extends Comparable<E>> void sort(E[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 寻找元素a[i]合适的插入位置
            E e = a[i];
            int j;
            for (j = i; j > 0 && Sorts.less(e, a[j - 1]); j--) {
                a[j] = a[j - 1];
            }
            a[j] = e;
        }
    }

}
