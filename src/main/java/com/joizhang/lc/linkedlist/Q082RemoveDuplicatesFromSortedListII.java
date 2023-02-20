package com.joizhang.lc.linkedlist;

/**
 * 82. 删除排序链表中的重复元素 II
 */
public class Q082RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
            ListNode next = cur.next;
            while (next != null && cur.val == next.val) {
                next = next.next;
            }
            if (next != cur.next) {
                pre.next = next;
            } else {
                pre = cur;
            }
            cur = next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q082RemoveDuplicatesFromSortedListII test = new Q082RemoveDuplicatesFromSortedListII();
        ListNode head = new ListNode(new int[]{1, 2, 3, 3, 4, 4, 5});
        System.out.println(test.deleteDuplicates(head));
        head = new ListNode(new int[]{1, 1, 1, 2, 3});
        System.out.println(test.deleteDuplicates(head));
    }
}
