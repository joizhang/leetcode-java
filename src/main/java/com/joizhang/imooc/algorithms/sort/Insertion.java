package com.joizhang.imooc.algorithms.sort;

/**
 * 插入排序。插入排序的时间复杂度取决于数组的初始顺序，如果数组已经部分有序了，
 * 那么逆序较少，需要的交换次数也就较少，时间复杂度较低。
 * <ul>
 * <li>平均情况下插入排序需要 ~N2/4 比较以及 ~N2/4 次交换；</li>
 * <li>最坏的情况下需要 ~N2/2 比较以及 ~N2/2 次交换，最坏的情况是数组是倒序的；</li>
 * <li>最好的情况下需要 N-1 次比较和 0 次交换，最好的情况就是数组已经有序了。</li>
 * <ul/>
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
