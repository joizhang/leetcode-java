package com.joizhang.imooc.algorithms.sort;

/**
 * <p>快速排序</p>
 * <p>近乎有序的数组快速排序退化为O(n^2)</p>
 * <p>重复元素很多的数组快速排序退化为O(n^2)</p>
 */
public interface Quick {

    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    static <E extends Comparable<E>> void quickSort(E[] arr, int l, int r) {
        // 优化：在小到一定程度时使用插入排序
        if (r - l <= 15) {
            Sorts.insertionSort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    /**
     * <p>对 a[l...r] 部分进行 partition 操作
     * <p>返回 j 使得 a[l...j-1] < a[j]; a[j+1...r] >= a[j]
     * <p>当数组长度较大，且包含大量重复元素时会产生 stack overflow
     */
    static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        // 随机在 a[l...r] 的范围中选择一个数值作为标定点 pivot
        int randInt = l + (int) (Math.random() * (r - l + 1));
        Sorts.exchange(arr, l, randInt);
        E v = arr[l];
        // a[l+1...j] < v; a[j+1...i] >= v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (Sorts.less(arr[i], v)) {
                Sorts.exchange(arr, j + 1, i);
                j++;
            }
        }
        Sorts.exchange(arr, l, j);
        return j;
    }

}
