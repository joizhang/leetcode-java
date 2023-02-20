package com.joizhang.lc.tree;

import com.joizhang.lc.linkedlist.ListNode;

/**
 * 109. 有序链表转换二叉搜索树
 */
public class Q109ConvertSortedListToBinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return new TreeNode(head.val);

        // 快慢指针找中心节点
        ListNode p = head, q = head, pre = null;
        while (q != null && q.next != null) {
            pre = p;
            p = p.next;
            q = q.next.next;
        }
        // p是中心节点，pre是p的前一个节点，p.next是p的下一个节点
        pre.next = null;
        TreeNode root = new TreeNode(p.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(p.next);
        return root;
    }

    public static void main(String[] args) {
        Q109ConvertSortedListToBinarySearchTree test = new Q109ConvertSortedListToBinarySearchTree();
        Codec codec = new Codec();
        ListNode head = new ListNode(new int[]{-10, -3, 0, 5, 9});
        TreeNode root = test.sortedListToBST(head);
        System.out.println(codec.serialize(root));
    }
}
