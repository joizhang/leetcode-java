package com.joizhang.lc.linkedlist;

/**
 * 876. Middle of the Linked List
 */
public class Q876MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        Q876MiddleOfTheLinkedList test = new Q876MiddleOfTheLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.middleNode(head));
        head = new ListNode(new int[]{1, 2, 3, 4, 5, 6});
        System.out.println(test.middleNode(head));
        head = new ListNode(new int[]{1});
        System.out.println(test.middleNode(head));
        head = new ListNode(new int[]{1, 2});
        System.out.println(test.middleNode(head));
    }
}
