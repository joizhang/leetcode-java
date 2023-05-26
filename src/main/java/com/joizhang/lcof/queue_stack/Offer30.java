package com.joizhang.lcof.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 剑指 Offer 30. 包含min函数的栈
 */
public class Offer30 {
    static class MinStack {

        final private Deque<Integer> stack;
        final private Deque<Integer> minStack;

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
            if (stack.isEmpty() || minStack.isEmpty()) {
                return;
            }
            Integer x = stack.pop();
            if (x.equals(minStack.peek())) {
                minStack.pop();
            }
        }

        public int top() {
            if (stack.isEmpty()) {
                throw new RuntimeException("Stack is empty!");
            }
            return stack.peek();
        }

        public int min() {
            if (minStack.isEmpty()) {
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
        System.out.println(minStack.min());   //--> 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());   //--> 返回 0.
        System.out.println(minStack.min());   //--> 返回 -2.
    }
}
