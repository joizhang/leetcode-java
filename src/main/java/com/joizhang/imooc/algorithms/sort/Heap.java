package com.joizhang.imooc.algorithms.sort;

/**
 * 堆排序
 */
public interface Heap {

    static <E extends Comparable<E>> void sort(E[] a) {
        if (a.length < 2) {
            return;
        }
        int n = a.length;
        // Heapify，从最后一个非叶子节点开始，形成一个最小堆
        for (int i = parent(n - 1); i >= 0; i--) {
            shiftDown(a, n, i);
        }

        // 将最小堆的第一个元素与最后一个元素交换，然后缩小数组范围进行 heapify
        for (int i = n - 1; i > 0; i--) {
            Sorts.exchange(a, 0, i);
            shiftDown(a, i, 0);
        }
    }

    static int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    static int leftChild(int index) {
        return index * 2 + 1;
    }

    static int rightChild(int index) {
        return index * 2 + 2;
    }

    static <E extends Comparable<E>> void shiftDown(E[] a, int n, int k) {
        while (leftChild(k) < n) {
            int j = leftChild(k);
            if (j + 1 < n && Sorts.less(a[leftChild(k)], a[rightChild(k)])) {
                j = rightChild(k);
            }
            if (!Sorts.less(a[k], a[j])) {
                break;
            }
            Sorts.exchange(a, j, k);
            k = j;
        }
    }

}
