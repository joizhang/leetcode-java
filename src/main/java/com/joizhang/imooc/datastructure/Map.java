package com.joizhang.imooc.datastructure;

public interface Map<K, V> {

    int getSize();

    boolean isEmpty();

    void put(K key, V value);

    V get(K key);

    boolean containsKey(K key);

    V remove(K key);
}
