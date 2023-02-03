package com.joizhang.lcof.linkedlist;

/**
 * 剑指 Offer 52. 两个链表的第一个公共节点
 */
public class Offer52 {
    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA != null ? pA.next : headB;
            pB = pB != null ? pB.next : headA;
        }
        return pA;
    }
}
