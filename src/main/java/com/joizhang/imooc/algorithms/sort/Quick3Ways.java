package com.joizhang.imooc.algorithms.sort;

/**
 * 3路快速排序
 */
public interface Quick3Ways {

    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        quickSort3Ways(arr, 0, n - 1);
    }

    static <E extends Comparable<E>> void quickSort3Ways(E[] arr, int l, int r) {
        if (r - l <= 15) {
            Sorts.insertionSort(arr, l, r);
            return;
        }

        // partition
        int randInt = l + (int) (Math.random() * (r - l + 1));
        Sorts.exchange(arr, l, randInt);
        E v = arr[l];
        // a[l+1...lt] < v
        int lt = l;
        // a[gt...r] > v
        int gt = r + 1;
        // a[lt+1...i] == v
        int i = l + 1;
        while (i < gt) {
            if (Sorts.less(arr[i], v)) {
                Sorts.exchange(arr, i, lt + 1);
                lt++;
                i++;
            } else if (Sorts.less(v, arr[i])) {
                Sorts.exchange(arr, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        Sorts.exchange(arr, l, lt);

        quickSort3Ways(arr, l, lt - 1);
        quickSort3Ways(arr, gt, r);
    }



}
