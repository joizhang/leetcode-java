package com.joizhang.lc.linkedlist;

/**
 * 237. 删除链表中的节点
 */
public class Q237DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
