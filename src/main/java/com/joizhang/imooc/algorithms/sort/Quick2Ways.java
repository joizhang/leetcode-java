package com.joizhang.imooc.algorithms.sort;

/**
 * 双路快速排序
 */
public interface Quick2Ways {

    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        quickSort2Ways(arr, 0, n - 1);
    }

    static <E extends Comparable<E>> void quickSort2Ways(E[] arr, int l, int r) {
        if (r - l <= 15) {
            Sorts.insertionSort(arr, l, r);
            return;
        }
        int p = partition(arr, l, r);
        quickSort2Ways(arr, l, p - 1);
        quickSort2Ways(arr, p + 1, r);
    }

    /**
     * <p>双路快速排序
     * <p>返回 j 使得 a[l...j-1] < a[j]; a[j+1...r] > a[j]
     */
    static <E extends Comparable<E>> int partition(E[] arr, int l, int r) {
        int randInt = l + (int) (Math.random() * (r - l + 1));
        Sorts.exchange(arr, l, randInt);
        E v = arr[l];
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && Sorts.less(arr[i], v)) {
                i++;
            }
            while (j >= l + 1 && Sorts.less(v, arr[j])) {
                j--;
            }
            if (i > j) break;
            Sorts.exchange(arr, i, j);
            i++;
            j--;
        }
        Sorts.exchange(arr, l, j);
        return j;
    }

}
