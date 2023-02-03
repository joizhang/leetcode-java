package com.joizhang.lcof.linkedlist;

/**
 * 剑指 Offer 22. 链表中倒数第k个节点
 */
public class Offer22 {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null) return null;
        ListNode first = head, second = head;
        int count = 0;
        while (first != null) {
            count++;
            first = first.next;
        }
        if (k > count) return null;

        first = head;
        for (int i = 0; i < k; i++) {
            second = second.next;
        }
        while (second != null) {
            second = second.next;
            first = first.next;
        }
        return first;
    }

    public static void main(String[] args) {
        Offer22 test = new Offer22();
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        head = test.getKthFromEnd(head, 6);
        System.out.println(head);
    }
}
