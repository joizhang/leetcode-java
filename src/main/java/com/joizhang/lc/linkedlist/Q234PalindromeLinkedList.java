package com.joizhang.lc.linkedlist;

/**
 * 234. 回文链表
 */
public class Q234PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        newHead = reverse(newHead);

        while (head != null && newHead != null) {
            if (head.val != newHead.val) {
                return false;
            }
            head = head.next;
            newHead = newHead.next;
        }
        return true;
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
        Q234PalindromeLinkedList test = new Q234PalindromeLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 2, 1});
        System.out.println(test.isPalindrome(head));
        head = new ListNode(new int[]{1, 2});
        System.out.println(test.isPalindrome(head));
        head = new ListNode(new int[]{1, 2, 1});
        System.out.println(test.isPalindrome(head));
    }
}
