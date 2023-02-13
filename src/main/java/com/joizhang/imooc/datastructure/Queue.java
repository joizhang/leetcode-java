package com.joizhang.imooc.datastructure;

/**
 * 队列接口
 *
 * @param <E>
 * @author joizhang
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    /**
     * 插入元素到队列
     * @param e 待入队元素
     */
    void offer(E e);

    /**
     * 删除队首元素并返回
     * @return 删除的元素
     */
    E poll();

    /**
     * 返回队首的元素，不会删除
     * @return 队首元素
     */
    E peek();

}