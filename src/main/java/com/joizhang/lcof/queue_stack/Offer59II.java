package com.joizhang.lcof.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 面试题59 - II. 队列的最大值
 */
public class Offer59II {
    static class MaxQueue {
        private final Deque<Integer> queue;
        // 单调双向队列
        private final Deque<Integer> deque;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            deque = new ArrayDeque<>();
        }

        public int max_value() {
            if (deque.isEmpty()) return -1;
            return deque.getFirst();
        }

        public void push_back(int value) {
            queue.offer(value);
            if (deque.isEmpty() || deque.peekLast() >= value) {
                deque.offerLast(value);
                return;
            }
            while (!deque.isEmpty() && value > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) return -1;
            Integer value = queue.poll();
            if (value.equals(deque.peekFirst())) {
                deque.pollFirst();
            }
            return value;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());

        // "MaxQueue","max_value","pop_front","max_value","push_back","max_value","pop_front","max_value"
        // [],[],[],[],[46],[],[],[]
        // null,-1,-1,-1,null,46,46,46,
        // null,-1,-1,-1,null,46,46,-1,
        maxQueue = new MaxQueue();
        maxQueue.push_back(46);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
