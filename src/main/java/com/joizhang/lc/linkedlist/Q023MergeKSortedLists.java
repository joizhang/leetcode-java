package com.joizhang.lc.linkedlist;

/**
 * 23. 合并K个升序链表
 */
public class Q023MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int lo, int hi) {
        if (lo == hi) return lists[lo];
        int mid = (lo + hi) / 2;
        ListNode l1 = merge(lists, lo, mid);
        ListNode l2 = merge(lists, mid + 1, hi);
        return mergeTwoLists(l1, l2);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode dummy = new ListNode(0);
        ListNode move = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                move.next = l1;
                l1 = l1.next;
            } else {
                move.next = l2;
                l2 = l2.next;
            }
            move = move.next;
        }
        if (l1 != null) move.next = l1;
        else move.next = l2;
        return dummy.next;
    }

    public static void main(String[] args) {
        Q023MergeKSortedLists test = new Q023MergeKSortedLists();
        ListNode[] lists = new ListNode[]{
                new ListNode(new int[]{1, 4, 5}),
                new ListNode(new int[]{1, 3, 4  }),
                new ListNode(new int[]{2, 6})
        };
        System.out.println(test.mergeKLists(lists).toString());
        lists = new ListNode[]{};
        System.out.println(test.mergeKLists(lists));
    }
}
