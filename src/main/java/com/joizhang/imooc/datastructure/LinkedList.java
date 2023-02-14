package com.joizhang.imooc.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.StringJoiner;

/**
 * 链表
 *
 * @param <E>
 * @author joizhang
 */
public class LinkedList<E> implements List<E> {

    private class Node {
        E item;
        Node next;

        Node(E item, Node next) {
            this.item = item;
            this.next = next;
        }

        Node(E item) {
            this(item, null);
        }

        Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Node.class.getSimpleName() + "[", "]")
                    .add("item=" + item)
                    .toString();
        }
    }

    private final Node dummyHead;

    private int size;

    public LinkedList() {
        dummyHead = new Node();
        size = 0;
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
    public void add(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(elem, prev.next);
        size++;
    }

    @Override
    public void addFirst(E elem) {
        add(0, elem);
    }

    @Override
    public void addLast(E elem) {
        add(size, elem);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.item;
    }

    @Override
    public E getLast() {
        return get(size - 1);
    }

    @Override
    public void set(int index, E elem) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index.");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.item = elem;
    }

    @Override
    public boolean contains(E elem) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.item.equals(elem)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    @Override
    public int find(E elem) {
        return 0;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;
        size--;
        return retNode.item;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void removeElement(E elem) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.item.equals(elem)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
        }
    }

    @Override
    public void swap(int i, int j) {

    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node cur;

            @Override
            public boolean hasNext() {
                return false;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return null;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur).append("->");
        }
        res.append("NULL");
        return res.toString();
    }
}
