package com.joizhang.lc.linkedlist;

public class Q2AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            if (l1 != null && l2 != null) {
                int sum = l1.val + l2.val + extra;
                move.next = new ListNode(sum % 10);
                extra = sum / 10;
                l1 = l1.next;
                l2 = l2.next;
            } else if (l1 != null) {
                int sum = l1.val + extra;
                move.next = new ListNode(sum % 10);
                extra = sum / 10;
                l1 = l1.next;
            } else if (l2 != null) {
                int sum = l2.val + extra;
                move.next = new ListNode(sum % 10);
                extra = sum / 10;
                l2 = l2.next;
            } else {
                int sum = extra;
                move.next = new ListNode(sum % 10);
                extra = sum / 10;
            }
            move = move.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q2AddTwoNumbers test = new Q2AddTwoNumbers();
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        System.out.println(test.addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(new int[]{0});
        l2 = new ListNode(new int[]{0});
        System.out.println(test.addTwoNumbers(l1, l2).toString());

        l1 = new ListNode(new int[]{9, 9, 9, 9, 9, 9, 9});
        l2 = new ListNode(new int[]{9, 9, 9, 9});
        System.out.println(test.addTwoNumbers(l1, l2).toString());
    }
}
