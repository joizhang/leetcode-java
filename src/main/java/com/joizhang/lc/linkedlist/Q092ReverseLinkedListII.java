package com.joizhang.lc.linkedlist;

/**
 * 92. 反转链表 II
 */
public class Q092ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        for (int i = 0; i < right; i++) {
            end = end.next;
        }

        ListNode start = pre.next;
        ListNode end_next = end.next;

        end.next = null;
        pre.next = this.reverse(start);
        start.next = end_next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
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

    public static void main(String[] args) {
        Q092ReverseLinkedListII test = new Q092ReverseLinkedListII();
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(test.reverseBetween(head, 2, 4));
        head = new ListNode(new int[]{5});
        System.out.println(test.reverseBetween(head, 1, 1));
    }
}
