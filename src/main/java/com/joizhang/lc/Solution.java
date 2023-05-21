package com.joizhang.lc;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    class CQueue {

        private final Deque<Integer> stackIn;
        private final Deque<Integer> stackOut;

        public CQueue() {
            stackIn = new ArrayDeque<>();
            stackOut = new ArrayDeque<>();
        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if (!stackOut.isEmpty()) return stackOut.pop();
            if (stackIn.isEmpty()) return -1;
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
    }
}
