package com.joizhang.lc.linkedlist;

/**
 * 143. 重排链表
 */
public class Q143ReorderList {
    // 1. 把链表存储到线性表中，然后用双指针依次从头尾取元素即可
    // 2. 递归
    // 3. 将链表平均分成两半，然后将将第二个链表逆序，然后依次连接两个链表
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);

        while (newHead != null) {
            ListNode l1 = head.next;
            ListNode l2 = newHead.next;
            head.next = newHead;
            newHead.next = l1;
            head = l1;
            newHead = l2;
        }
    }

    private ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode p = head;
        while (p != null) {
            head = head.next;
            p.next = dummy.next;
            dummy.next = p;
            p = head;
        }
        return dummy.next;
    }
}
