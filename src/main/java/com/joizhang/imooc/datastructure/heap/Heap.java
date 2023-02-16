package com.joizhang.imooc.datastructure.heap;

import com.joizhang.imooc.datastructure.ArrayList;

public interface Heap<E extends Comparable<E>> {

    int size();

    boolean isEmpty();

    /**
     * 向堆中添加元素
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 返回堆顶元素
     *
     * @return 堆顶元素
     */
    E getElement();

    /**
     * 取出堆顶元素
     * @return 堆顶元素
     */
    E extractElement();

    /**
     * 取出堆顶元素
     *
     * @param data 堆
     * @return 堆顶元素
     */
    default E extractElement(ArrayList<E> data) {
        E ret = getElement();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        return ret;
    }

}
