package com.joizhang.lcof.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 34. 二叉树中和为某一值的路径
 */
public class Offer36 {
    // Definition for a Node.
    static class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }

    Node head = null;
    Node pre = null;

    public Node treeToDoublyList(Node root) {
        if (root == null) return null;
        recur(root);
        head.left = pre;
        pre.right = head;
        return head;
    }

    // 二叉搜索树的中序遍历为 递增序列
    private void recur(Node root) {
        if (root == null) return;
        recur(root.left);
        if (pre != null) {
            pre.right = root;
        } else {
            head = root;
        }
        root.left = pre;
        pre = root;
        recur(root.right);
    }

    public static void main(String[] args) {
        Offer36 test = new Offer36();
        Node node4 = new Node(4);
        Node node2 = new Node(2);
        Node node5 = new Node(5);
        node4.left = node2;
        node4.right = node5;
        Node node1 = new Node(1);
        Node node3 = new Node(3);
        node2.left = node1;
        node2.right = node3;
        Node node = test.treeToDoublyList(node4);
        List<Integer> arr = new ArrayList<>();
        Node p = node;
        while (p != null && !arr.contains(p.val)) {
            arr.add(p.val);
            p = p.right;
        }
        System.out.println(arr);
    }
}
