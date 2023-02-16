package com.joizhang.lcof.linkedlist;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 剑指 Offer 06. 从尾到头打印链表
 */
public class Offer06 {
    // 栈
    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[]{};
        Deque<Integer> stack = new ArrayDeque<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        Offer06 test = new Offer06();
        ListNode head = new ListNode(new int[]{1, 3, 2});
        System.out.println(Arrays.toString(test.reversePrint(head)));
    }
}
