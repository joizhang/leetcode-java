package com.joizhang.lc.linkedlist;

/**
 * 148. 排序链表
 */
public class Q148SortList {
    // 归并排序
    public ListNode sortList(ListNode head) {
        // 递归结束条件
        if (head == null || head.next == null) return head;

        // 将链表拆分为两个部分
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;

        // 归并排序
        ListNode left = sortList(head);
        ListNode right = sortList(newHead);
        return mergeTwoSortedList(left, right);
    }

    private ListNode mergeTwoSortedList(ListNode l1, ListNode l2) {
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
        if (l1 == null) {
            move.next = l2;
        } else {
            move.next = l1;
        }
        return dummy.next;
    }

    // 快速排序
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = new ListNode(0);
        pre.next = head;
        quickSort(pre, null);
        return pre.next;
    }

    private void quickSort(ListNode pre, ListNode end) {
        //如果节点数小于1就返回
        if (pre == end || pre.next == end || pre.next.next == end) return;
        //选第一个节点为基准，pre.next为大于等于v的头节点
        ListNode v = pre.next;
        //建立临时链表，cur为小于v的链表
        ListNode cur = new ListNode(0);
        ListNode l = cur, r = v;
        while (r.next != end) {
            //如果当前元素小于基准，就加入临时链表，并在原链表中删除
            if (r.next.val < v.val) {
                l.next = r.next;
                r.next = r.next.next;
                l = l.next;
            } else {
                r = r.next;
            }
        }
        l.next = pre.next;
        pre.next = cur.next;

        quickSort(pre, v);
        quickSort(v, end);
    }

    public static void main(String[] args) {
        Q148SortList test = new Q148SortList();
        ListNode head = new ListNode(new int[]{4, 2, 1, 3});
        System.out.println(test.sortList(head));
        head = new ListNode(new int[]{5, 4, 3, 2, 1});
        System.out.println(test.sortList(head));

        head = new ListNode(new int[]{4, 2, 1, 3});
        System.out.println(test.sortList2(head));
        head = new ListNode(new int[]{5, 4, 3, 2, 1});
        System.out.println(test.sortList2(head));
    }
}
