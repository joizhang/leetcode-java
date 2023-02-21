package com.joizhang.lc.tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 */
public class Q116PopulatingNextRightPointersInEachNode {
    // 层序遍历
    public Node connect(Node root) {
        if (root == null) return null;
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Node temp = queue.poll();
                if (i < size - 1) {
                    temp.next = queue.peek();
                }
                if (temp.left != null) {
                    queue.offer(temp.left);
                }
                if (temp.left != null) {
                    queue.offer(temp.right);
                }
            }
        }
        return root;
    }

    // 使用已建立的 next 指针
    public Node connect2(Node root) {
        if (root == null) return null;
        // leftmost一直是某一层最左的结点
        Node leftmost = root;
        while (leftmost.left != null) {
            // 遍历这一层节点组织成的链表，为下一层的节点更新 next 指针
            Node head = leftmost;
            while (head != null) {
                // 左结点连接右结点
                head.left.next = head.right;
                // 右结点连接左结点
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                head = head.next;
            }
            leftmost = leftmost.left;
        }
        return root;
    }
}
