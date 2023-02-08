package com.joizhang.imooc.datastructure;

import java.util.LinkedList;

public class HashMap<K, V> implements Map<K, V> {

    static final float LOAD_FACTOR = 0.75f;

    class Node {
        K key;
        V value;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private int size;

    private LinkedList<Node>[] buckets;

    public HashMap() {
        this(16);
    }

    public HashMap(int capacity) {
        initBuckets(capacity);
        size = 0;
    }

    @SuppressWarnings("unchecked")
    private void initBuckets(int capacity) {
        buckets = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void put(K key, V value) {
        int bucketIndex = hash(key);
        LinkedList<Node> nodes = buckets[bucketIndex];
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }

        nodes.add(new Node(key, value));
        size++;
        if ((float) size / buckets.length > LOAD_FACTOR) {
            rehash();
        }
    }

    private int hash(K key) {
        int hashCode = key.hashCode();
        return Math.abs(hashCode) % buckets.length;
    }

    private void rehash() {
        LinkedList<Node>[] old = buckets;
        initBuckets(old.length * 2);
        size = 0;
        for (LinkedList<Node> nodes : old) {
            for (Node node : nodes) {
                put(node.key, node.value);
            }
        }
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key);
        LinkedList<Node> nodes = buckets[bucketIndex];
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public V remove(K key) {
        int bucketIndex = hash(key);
        LinkedList<Node> nodes = buckets[bucketIndex];
        Node target = null;
        for (Node node : nodes) {
            if (node.key.equals(key)) {
                target = node;
                break;
            }
        }
        nodes.remove(target);
        size--;
        return target != null ? target.value : null;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("HashMap: size=").append(size).append(", capacity=").append(buckets.length).append(", data=");
        res.append('{');
        for (LinkedList<Node> nodes : buckets) {
            for (Node node : nodes) {
                res.append(node.key).append(":").append(node.value).append(", ");
            }
        }
        res.append("}");
        return res.toString();
    }
}
