package com.joizhang.lcof.linkedlist;

/**
 * 剑指 Offer 18. 删除链表的节点
 */
public class Offer18 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) return null;
        if (head.val == val) return head.next;
        ListNode first = head, second = head.next;
        while (second != null) {
            if (second.val == val) {
                first.next = second.next;
                break;
            }
            first = first.next;
            second = second.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Offer18 test = new Offer18();
        ListNode head = new ListNode(new int[]{4,5,1,9});
        head = test.deleteNode(head, 5);
        System.out.println(head.toString());
    }
}
