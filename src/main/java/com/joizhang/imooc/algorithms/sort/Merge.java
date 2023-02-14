package com.joizhang.imooc.algorithms.sort;

/**
 * 自顶向下归并排序。将一个大数组分成两个小数组去求解。因为每次都将问题对半分成两个子问题，
 * 这种对半分的算法复杂度一般为 O(NlogN)。
 */
public interface Merge {

    @SuppressWarnings("unchecked")
    static <E extends Comparable<E>> void sort(E[] arr) {
        int n = arr.length;
        E[] aux = (E[]) new Comparable[arr.length];
        mergeSort(arr, aux, 0, n - 1);
    }

    /**
     * 递归使用归并排序，对 a[l...r]的范围进行排序
     */
    static <E extends Comparable<E>> void mergeSort(E[] arr, E[] aux, int l, int r) {
        // 优化 1：在小到一定程度时使用插入排序
        if (r - l <= 15) {
            Sorts.insertionSort(arr, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        mergeSort(arr, aux, l, mid);
        mergeSort(arr, aux, mid + 1, r);
        // 优化 2：当arr[mid + 1] < arr[mid]时才进行归并
        if (Sorts.less(arr[mid + 1], arr[mid])) {
            merge(arr, aux, l, mid, r);
        }
    }

    /**
     * 将 a[l...mid] 和 a[mid+1...r] 两部分进行归并
     */
    static <E extends Comparable<E>> void merge(E[] arr, E[] aux, int l, int mid, int r) {
        // 将数据复制到辅助数组，可以用System.arraycopy
        for (int i = l; i <= r; i++) {
            aux[i] = arr[i];
        }

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j];
                j++;
            } else if (j > r) {
                arr[k] = aux[i];
                i++;
            } else if (Sorts.less(aux[i], aux[j])) {
                arr[k] = aux[i];
                i++;
            } else {
                arr[k] = aux[j];
                j++;
            }
        }
    }

}
