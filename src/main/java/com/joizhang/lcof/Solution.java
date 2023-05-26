package com.joizhang.lcof;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    static class MinStack {

        private final Deque<Integer> stack;

        private final Deque<Integer> minStack;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.push(x);
            if (minStack.isEmpty() || minStack.peek() >= x) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            Integer x = stack.pop();
            if (x.equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
    }
}
