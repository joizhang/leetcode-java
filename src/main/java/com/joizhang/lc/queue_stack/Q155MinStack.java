package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 155. 最小栈
 */
public class Q155MinStack {
    static class MinStack {
        private final Deque<Integer> stack;
        private final Deque<Integer> minStack;

        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int val) {
            stack.push(val);
            if (minStack.isEmpty() || val <= minStack.peek()) {
                minStack.push(val);
            }
        }

        public void pop() {
            if (stack.isEmpty() || minStack.isEmpty()) {
                return;
            }
            if (stack.peek().equals(minStack.peek())) {
                minStack.pop();
            }
            stack.pop();
        }

        public int top() {
            if (stack.isEmpty() || minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            return stack.peek();
        }

        public int getMin() {
            if (stack.isEmpty() || minStack.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            return minStack.peek();
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());//--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());//--> 返回 0.
        System.out.println(minStack.getMin());//--> 返回 -2.
    }
}
