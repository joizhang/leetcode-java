package com.joizhang.imooc.datastructure;

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    /**
     * 插入键值对到Map中
     * @param key key
     * @param value value
     */
    void put(K key, V value);

    /**
     * 获得键对应的值
     * @param key key
     * @return 键对应的值
     */
    V get(K key);

    /**
     * 如果Map中包含该键值对则返回true
     * @param key key
     * @return 如果Map中包含该键值对则返回true
     */
    boolean containsKey(K key);

    /**
     * 如果键值对存在则删除健值对
     * @param key key
     * @return 键对应的值，如果不存在返回null
     */
    V remove(K key);

}
