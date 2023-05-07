package com.joizhang.lc;

import com.joizhang.lc.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public ListNode reverseList(ListNode head) {
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
        Solution test = new Solution();
        ListNode head = new ListNode(new int[]{1,2,3,4,5});
        System.out.println(test.reverseList(head));
    }
}
