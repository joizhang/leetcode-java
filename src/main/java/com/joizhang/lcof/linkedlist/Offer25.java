package com.joizhang.lcof.linkedlist;

/**
 * 剑指 Offer 25. 合并两个排序的链表
 */
public class Offer25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        if (l1 != null) {
            move.next = l1;
        } else {
            move.next = l2;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Offer25 test = new Offer25();
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        System.out.println(test.mergeTwoLists(l1, l2));
    }
}
