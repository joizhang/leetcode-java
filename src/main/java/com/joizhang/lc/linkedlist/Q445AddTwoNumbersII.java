package com.joizhang.lc.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 445. 两数相加 II
 */
public class Q445AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Deque<ListNode> stack1 = new ArrayDeque<>();
        Deque<ListNode> stack2 = new ArrayDeque<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        ListNode head = null;
        int carry = 0;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int sum = carry;
            if (!stack1.isEmpty()) {
                sum += stack1.pop().val;
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop().val;
            }
            ListNode node = new ListNode(sum % 10);
            node.next = head;
            head = node;
            carry = sum / 10;
        }
        return head;
    }

    public static void main(String[] args) {
        Q445AddTwoNumbersII test = new Q445AddTwoNumbersII();
        ListNode l1 = new ListNode(new int[]{7, 2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        System.out.println(test.addTwoNumbers(l1, l2));

        l1 = new ListNode(new int[]{2, 4, 3});
        l2 = new ListNode(new int[]{5, 6, 4});
        System.out.println(test.addTwoNumbers(l1, l2));

        l1 = new ListNode(new int[]{5});
        l2 = new ListNode(new int[]{5});
        System.out.println(test.addTwoNumbers(l1, l2));
    }
}
