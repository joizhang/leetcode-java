package com.joizhang.lc.linkedlist;

/**
 * 206. 反转链表
 */
public class Q206ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (head != null) {
            head = head.next;
            p.next = dummy.next;
            dummy.next = p;
            p = head;
        }
        return dummy.next;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode newHead = reverseList2(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args) {
        Q206ReverseLinkedList test = new Q206ReverseLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseList(head));

        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseList2(head));
    }
}
