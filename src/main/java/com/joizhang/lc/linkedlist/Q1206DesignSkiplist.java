package com.joizhang.lc.linkedlist;

import java.util.Random;

/**
 * 1206. 设计跳表
 */
public class Q1206DesignSkiplist {

    static class Skiplist {

        /**
         * 最大层数
         */
        private static final int level = 10;

        private class Node {
            Integer val; // 结点值
            Node[] nexts; // 结点在不同层的下一个结点

            /**
             * @param value 结点值
             */
            public Node(Integer value) {
                this.val = value;
                this.nexts = new Node[level];
            }

        }

        /**
         * 哨兵
         */
        Node head = new Node(-1);

        Random random = new Random();

        public Skiplist() {

        }

        void find(int target, Node[] nodes) {
            Node cur = head;
            for (int i = level - 1; i >= 0; i--) {
                while (cur.nexts[i] != null && cur.nexts[i].val < target) {
                    cur = cur.nexts[i];
                }
                nodes[i] = cur;
            }
        }

        public boolean search(int target) {
            Node[] nodes = new Node[level];
            find(target, nodes);
            return nodes[0].nexts[0] != null && nodes[0].nexts[0].val == target;
        }

        public void add(int num) {
            Node[] nodes = new Node[level];
            find(num, nodes);
            // 创建插入元素节点
            Node node = new Node(num);
            for (int i = 0; i < level; i++) {
                node.nexts[i] = nodes[i].nexts[i];
                nodes[i].nexts[i] = node;
                if (random.nextInt(2) == 1) {
                    break;
                }
            }
        }

        public boolean erase(int num) {
            Node[] nodes = new Node[level];
            find(num, nodes);
            // 检验是否存在
            Node node = nodes[0].nexts[0];
            if (node == null || node.val != num) {
                return false;
            }
            for (int i = 0; i < level && nodes[i].nexts[i] == node; i++) {
                // 删除
                nodes[i].nexts[i] = nodes[i].nexts[i].nexts[i];
            }
            return true;
        }
    }

    public static void main(String[] args) {
        Skiplist obj = new Skiplist();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        System.out.println(obj.search(0));
        obj.add(4);
        obj.search(1);
        obj.erase(0);
        obj.erase(1);
        System.out.println(obj.search(1));
    }

}
