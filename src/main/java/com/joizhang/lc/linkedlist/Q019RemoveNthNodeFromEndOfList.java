package com.joizhang.lc.linkedlist;

/**
 * 19. 删除链表的倒数第 N 个结点
 */
public class Q019RemoveNthNodeFromEndOfList {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        for (int i = 0; i< n; i++) {
            first = first.next;
        }
        ListNode second = dummy;
        while (first.next != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }

    public static void main(String[] args) {
        Q019RemoveNthNodeFromEndOfList test = new Q019RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(test.removeNthFromEnd(head, 2).toString());

        head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(test.removeNthFromEnd(head, 5).toString());
    }
}
