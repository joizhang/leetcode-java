package com.joizhang.lcof.linkedlist;

public class Offer24 {
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

    public static void main(String[] args) {
        Offer24 test = new Offer24();
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(test.reverseList(head).toString());
    }
}
