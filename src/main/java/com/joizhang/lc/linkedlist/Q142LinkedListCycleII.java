package com.joizhang.lc.linkedlist;

/**
 * 142. 环形链表 II
 */
public class Q142LinkedListCycleII {
    /**
     * 为什么快慢指针就一定能判断是否有环？
     *
     * <p>假如有环，那么快慢指针最终都会走到环上，假如环的长度是m，快慢指针最近的间距是n
     * 快指针每次走两步，慢指针每次走一步，所以每走一次快慢指针的间距就要缩小一步
     *
     * <p>如何确定环的入口
     *
     * <p>设链表共有 a+b 个节点，其中 链表头部到链表入口有 a 个节点（不计链表入口节点），
     * 链表环有 b 个节点；设两指针分别走了 f，s 步，则有：
     *
     * <p>1. fast走的步数是slow的2倍，即 f=2s；（fast每轮走两步）
     *
     * <p>2. fast比slow多走了n个环的长度，即 f=s+nb；(双指针都走过a步，然后在环内
     * 绕圈直到重合，重合时fast比slow多走环的长度整数倍)
     *
     * <p>以上两式相减得：f=2nb，s=nb，即fast和slow指针分别走了2n，n个环的周长
     * 如果让指针从链表头部一直向前走并统计步数k，那么所有 走到链表入口节点时的步数 是：
     * k=a+nb（先走 a 步到入口节点，之后每绕 1 圈环（b 步）都会再次到入口节点）。
     *
     * <p>而目前，slow 指针走过的步数为nb 步。因此，我们只要想办法让 slow 再走
     * a 步停下来，就可以到环的入口。
     */
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        boolean hasCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }
        if (!hasCycle) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}
