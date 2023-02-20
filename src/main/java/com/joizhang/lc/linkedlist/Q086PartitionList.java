package com.joizhang.lc.linkedlist;

/**
 * 86. 分隔链表
 */
public class Q086PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode headSmall = new ListNode(0);
        ListNode small = headSmall;
        ListNode headLarge = new ListNode(0);
        ListNode large = headLarge;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = headLarge.next;
        return headSmall.next;
    }

    public static void main(String[] args) {
        Q086PartitionList test = new Q086PartitionList();
        ListNode head = new ListNode(new int[]{1, 4, 3, 2, 5, 2});
        System.out.println(test.partition(head, 3));
    }
}
