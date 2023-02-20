package com.joizhang.lc.linkedlist;

/**
 * 24. 两两交换链表中的节点
 */
public class Q024SwapNodesInPairs {
    // 递归
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }

    // 非递归
    public ListNode swapPairs2(ListNode head) {
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
        Q024SwapNodesInPairs test = new Q024SwapNodesInPairs();
        ListNode head = new ListNode(new int[]{1,2,3,4});
        System.out.println(test.swapPairs(head));
        head = new ListNode(new int[]{1,2,3});
        System.out.println(test.swapPairs(head));

        head = new ListNode(new int[]{1,2,3,4});
        System.out.println(test.swapPairs2(head));
        head = new ListNode(new int[]{1,2,3});
        System.out.println(test.swapPairs2(head));
    }
}
