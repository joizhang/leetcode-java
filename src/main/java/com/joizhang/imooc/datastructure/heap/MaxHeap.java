package com.joizhang.imooc.datastructure.heap;

import com.joizhang.imooc.datastructure.ArrayList;

public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private final ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    /**
     * 将任意数组整理成堆的形状<br>
     * 1. 将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)<br>
     * 2. heapify的过程，算法复杂度是O(n)
     */
    public MaxHeap(E[] arr) {
        data = new ArrayList<>(arr);
        // 从最后一个非叶子节点开始进行 shiftDown，最后一个非叶子节点为 parent(arr.length - 1)
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    @Override
    public int size() {
        return data.getSize();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    /**
     * 上浮
     */
    private void shiftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    @Override
    public E getElement() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cannot find maximum when heap is empty!");
        }
        return data.get(0);
    }

    @Override
    public E extractElement() {
        E ret = extractElement(data);
        shiftDown(0);
        return ret;
    }

    /**
     * 下沉，和孩子节点中最大的元素交换
     */
    private void shiftDown(int k) {
        // 终止条件为 k 节点没有孩子了
        while (leftChild(k) < data.getSize()) {
            // data[j] 是 leftChild 和 rightChild 中的最大值
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }
}
