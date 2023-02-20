package com.joizhang.lc.linkedlist;

/**
 * 61. 旋转链表
 */
public class Q061RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode p = head;
        int count = 0;
        while (p != null) {
            p = p.next;
            count++;
        }
        k = k % count;
        // 取余后k=0说明不需要旋转
        if (k == 0) return head;
        ListNode first = head, second = head;
        for (int i = 0; i < k; i++) {
            second = second.next;
        }
        while (second.next != null) {
            first = first.next;
            second = second.next;
        }
        ListNode res = first.next;
        first.next = null;
        second.next = head;
        return res;
    }

    public static void main(String[] args) {
        Q061RotateList test = new Q061RotateList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(test.rotateRight(head, 2));
        head = new ListNode(new int[]{0, 1, 2});
        System.out.println(test.rotateRight(head, 4));
    }
}
