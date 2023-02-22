package com.joizhang.lc.linkedlist;

/**
 * 328. 奇偶链表
 */
public class Q328OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        if (head == null) return null;
        ListNode odd = head, even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main(String[] args) {
        Q328OddEvenLinkedList test = new Q328OddEvenLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4});
        System.out.println(test.oddEvenList(head));
        head = new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7});
        System.out.println(test.oddEvenList(head));
    }
}
