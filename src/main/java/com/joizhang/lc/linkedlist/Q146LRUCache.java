package com.joizhang.lc.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU 缓存
 */
public class Q146LRUCache {
    static class LRUCache {

        static class ListNode {
            private final int key;
            private int value;
            private ListNode prev;
            private ListNode next;

            public ListNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private final int capacity;
        private final Map<Integer, ListNode> map;
        private final ListNode head;
        private final ListNode tail;

        public LRUCache(int capacity) {
            this.capacity = capacity;
            this.map = new HashMap<>();
            this.head = new ListNode(0, 0);
            this.tail = new ListNode(0, 0);
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        public int get(int key) {
            if (map.containsKey(key)) {
                moveNodeToTail(key);
            }
            ListNode res = map.get(key);
            if (res == null) {
                return -1;
            }
            else {
                return res.value;
            }
        }

        private void moveNodeToTail(int key) {
            ListNode node = map.get(key);
            // 将结点从链表中分离
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // 将node插入到尾节点前
            node.prev = this.tail.prev;
            node.next = this.tail;
            this.tail.prev.next = node;
            this.tail.prev = node;
        }

        public void put(int key, int value) {
            if (map.containsKey(key)) {
                map.get(key).value = value;
                moveNodeToTail(key);
            } else {
                // 缓存满，移除开头结点
                if (map.size() == this.capacity) {
                    map.remove(this.head.next.key);
                    this.head.next = this.head.next.next;
                    this.head.next.prev = this.head;
                }
                ListNode node = new ListNode(key, value);
                map.put(key, node);
                // 插入到链表开头
                node.prev = this.tail.prev;
                node.next = this.tail;
                this.tail.prev.next = node;
                this.tail.prev = node;
            }
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // 缓存是 {1=1}
        lruCache.put(2, 2); // 缓存是 {1=1, 2=2}
        System.out.println(lruCache.get(1));    // 返回 1
        lruCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lruCache.get(2));    // 返回 -1 (未找到)
        lruCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
        System.out.println(lruCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lruCache.get(3));    // 返回 3
        System.out.println(lruCache.get(4));    // 返回 4
    }
}
