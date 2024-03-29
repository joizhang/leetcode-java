package com.joizhang.imooc.algorithms.sort;

/**
 * 希尔排序。希尔排序使用插入排序对间隔 h 的序列进行排序。通过不断减小 h，
 * 最后令 h=1，就可以使得整个数组是有序的。
 */
public interface Shell {

    static <E extends Comparable<E>> void sort(E[] a) {
        int n = a.length;

        // 3x+1 increment sequence:  1, 4, 13, 40, 121, 364, 1093, ...
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            for (int i = h; i < n; i++) {
                for (int j = i; j >= h && Sorts.less(a[j], a[j - h]); j -= h) {
                    Sorts.exchange(a, j, j - h);
                }
            }
            h /= 3;
        }
    }

}
