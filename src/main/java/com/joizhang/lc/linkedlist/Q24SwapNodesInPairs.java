package com.joizhang.lc.linkedlist;

/**
 * 24. 两两交换链表中的节点
 */
public class Q24SwapNodesInPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        while (head != null && head.next != null) {
            first = first.next.next;
            second.next = first;
            head.next = first.next;
            first.next = head;
            first = head;
            second = head;
            head = head.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q24SwapNodesInPairs test = new Q24SwapNodesInPairs();
        ListNode head = new ListNode(new int[]{1,2,3,4});
        System.out.println(test.swapPairs(head));
        head = new ListNode(new int[]{1,2,3});
        System.out.println(test.swapPairs(head));
    }
}
