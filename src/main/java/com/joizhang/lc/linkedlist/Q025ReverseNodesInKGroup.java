package com.joizhang.lc.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 25. K 个一组翻转链表
 */
public class Q025ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        Deque<ListNode> stack = new ArrayDeque<>();
        while (true) {
            int i = k;
            ListNode temp = head;
            // 入队
            while (i != 0 && temp != null) {
                stack.push(temp);
                temp = temp.next;
                i -= 1;
            }
            // 剩余节点不足k
            if (i != 0) {
                p.next = head;
                break;
            }
            // 反转
            while (!stack.isEmpty()) {
                p.next = stack.pop();
                p = p.next;
            }

            p.next = temp;
            head = temp;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q025ReverseNodesInKGroup test = new Q025ReverseNodesInKGroup();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup(head, 2));
        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup(head, 3));
    }
}
