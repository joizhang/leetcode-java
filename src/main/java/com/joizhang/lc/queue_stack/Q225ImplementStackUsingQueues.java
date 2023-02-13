package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 225. 用队列实现栈
 */
public class Q225ImplementStackUsingQueues {
    static class MyStack {

        private Deque<Integer> queueA;
        private Deque<Integer> queueB;

        public MyStack() {
            queueA = new ArrayDeque<>();
            queueB = new ArrayDeque<>();
        }

        public void push(int x) {
            queueB.offer(x);
            while (!queueA.isEmpty()) {
                queueB.offer(queueA.poll());
            }
            Deque<Integer> temp = queueB;
            queueB = queueA;
            queueA = temp;
        }

        public int pop() {
            if (queueA.isEmpty()) {
                return -1;
            }
            return queueA.poll();
        }

        public int top() {
            if (queueA.isEmpty()) {
                return -1;
            }
            return queueA.peek();
        }

        public boolean empty() {
            return queueA.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }
}
