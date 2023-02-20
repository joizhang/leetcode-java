package com.joizhang.lc.linkedlist;

/**
 * 83. 删除排序链表中的重复元素
 */
public class Q083RemoveDuplicatesFromSortedList {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode first = head, second = head.next;
        while (second != null) {
            while (second != null && second.val == first.val) {
                second = second.next;
            }
            if (second == null) {
                first.next = null;
                break;
            }
            first.next = second;
            first = first.next;
            second = second.next;
        }
        return head;
    }

    // https://leetcode.cn/problems/remove-duplicates-from-sorted-list/solution/hua-jie-suan-fa-83-shan-chu-pai-xu-lian-biao-zhong/
    public ListNode deleteDuplicates2(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Q083RemoveDuplicatesFromSortedList test = new Q083RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(new int[]{1, 1, 2});
        System.out.println(test.deleteDuplicates(head));
        head = new ListNode(new int[]{1, 1, 2, 3, 3});
        System.out.println(test.deleteDuplicates(head));

        head = new ListNode(new int[]{1, 1, 2});
        System.out.println(test.deleteDuplicates2(head));
        head = new ListNode(new int[]{1, 1, 2, 3, 3});
        System.out.println(test.deleteDuplicates2(head));
    }
}
