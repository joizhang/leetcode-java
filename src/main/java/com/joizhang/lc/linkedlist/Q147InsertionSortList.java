package com.joizhang.lc.linkedlist;

/**
 * 147. 对链表进行插入排序
 */
public class Q147InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy, end = head;
        while (end.next != null) {
            if (end.val <= end.next.val) {
                end = end.next;
            } else {
                // 从链表中移除该节点
                ListNode temp = end.next;
                end.next = temp.next;
                // 找到适合插入的位置
                while (pre.next.val <= temp.val) {
                    pre = pre.next;
                }
                // 插入结点
                temp.next = pre.next;
                pre.next = temp;
                // 复位pre结点
                pre = dummy;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        Q147InsertionSortList test = new Q147InsertionSortList();
        ListNode head = new ListNode(new int[]{4, 2, 1, 3});
        System.out.println(test.insertionSortList(head));
        head = new ListNode(new int[]{-1, 5, 3, 4, 0});
        System.out.println(test.insertionSortList(head));
    }
}
