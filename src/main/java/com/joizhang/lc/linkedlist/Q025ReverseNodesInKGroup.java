package com.joizhang.lc.linkedlist;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 25. K 个一组翻转链表
 */
public class Q025ReverseNodesInKGroup {
    // 使用栈
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

    // 不使用栈
    public ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++){
                end = end.next;
            }
            if (end == null) break;
            // 截取中间链
            ListNode start = pre.next;
            ListNode endNext = end.next;
            end.next = null;
            // 翻转
            pre.next = reverse(start);
            start.next = endNext;

            pre = start;
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
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
        Q025ReverseNodesInKGroup test = new Q025ReverseNodesInKGroup();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup(head, 2));
        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup(head, 3));

        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup2(head, 2));
        head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.reverseKGroup2(head, 3));
    }
}
