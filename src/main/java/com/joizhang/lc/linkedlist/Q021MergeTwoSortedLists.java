package com.joizhang.lc.linkedlist;

/**
 * 21. 合并两个有序链表
 */
public class Q021MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                move.next = list1;
                list1 = list1.next;
            } else {
                move.next = list2;
                list2 = list2.next;
            }
            move = move.next;
        }
        if (list1 == null) {
            move.next = list2;
        } else {
            move.next = list1;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q021MergeTwoSortedLists test = new Q021MergeTwoSortedLists();
        ListNode l1 = new ListNode(new int[]{1, 2, 4});
        ListNode l2 = new ListNode(new int[]{1, 3, 4});
        System.out.println(test.mergeTwoLists(l1, l2).toString());

        l2 = new ListNode(new int[]{0});
        System.out.println(test.mergeTwoLists(null, l2).toString());
    }
}
