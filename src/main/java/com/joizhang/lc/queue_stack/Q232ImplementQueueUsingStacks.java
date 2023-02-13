package com.joizhang.lc.queue_stack;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. 用栈实现队列
 */
public class Q232ImplementQueueUsingStacks {
    static class MyQueue {

        private final Deque<Integer> stackIn;
        private final Deque<Integer> stackOut;

        public MyQueue() {
            stackIn = new ArrayDeque<>();
            stackOut = new ArrayDeque<>();
        }

        public void push(int x) {
            stackIn.push(x);
        }

        public int pop() {
            if (!stackOut.isEmpty()) {
                return stackOut.pop();
            }
            if (stackIn.isEmpty()) {
                return -1;
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.pop();
        }

        public int peek() {
            if (!stackOut.isEmpty()) {
                return stackOut.peek();
            }
            if (stackIn.isEmpty()) {
                return -1;
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            return stackOut.peek();
        }

        public boolean empty() {
            return stackIn.isEmpty() && stackOut.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        System.out.println(myQueue.peek()); // return 1
        System.out.println(myQueue.pop()); // return 1, queue is [2]
        System.out.println(myQueue.empty()); // return false
    }
}
