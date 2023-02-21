package com.joizhang.lc.tree;

/**
 * 117. 填充每个节点的下一个右侧节点指针 II
 */
public class Q117PopulatingNextRightPointersInEachNodeII {
    public Node connect(Node root) {
        if(root == null) return null;
        Node cur = root;
        while (cur != null) {
            // 遍历当前层的时候，为了方便操作在下一层前面添加一个哑结点
            Node dummy = new Node(0);
            // pre用于把结点连接起来
            Node pre = dummy;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            // cur 跳至下一层
            cur = dummy.next;
        }
        return root;
    }
}
