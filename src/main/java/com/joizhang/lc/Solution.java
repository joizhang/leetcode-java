package com.joizhang.lc;

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
            if (minStack.isEmpty() || x <= minStack.peek()) {
                minStack.push(x);
            }
        }

        public void pop() {
            if (stack.isEmpty()) throw new RuntimeException("Stack is empty.");
            Integer x = stack.pop();
            if (!minStack.isEmpty() && x.equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) throw new RuntimeException("Stack is empty.");
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) throw new RuntimeException("Stack is empty.");
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.min();   //--> 返回 -3.
        minStack.pop();
        minStack.top();      //--> 返回 0.
        minStack.min();   //--> 返回 -2.
    }
}
