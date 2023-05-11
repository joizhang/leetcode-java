package com.joizhang.lc;

import com.joizhang.imooc.datastructure.ArrayStack;
import com.joizhang.lc.linkedlist.ListNode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution {

    public int[] reversePrint(ListNode head) {
        if (head == null) return new int[0];
        Deque<Integer> stack = new ArrayDeque<>();
        while(head != null) {
            stack.push(head.val);
            head = head.next;
        }
        Object[] array = stack.toArray();
        return Arrays.stream(array).mapToInt(i-> (int) i).toArray();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
    }
}
