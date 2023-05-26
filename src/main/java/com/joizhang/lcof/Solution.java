package com.joizhang.lcof;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    static class MaxQueue {

        private final Deque<Integer> queue;

        private final Deque<Integer> maxQueue;

        public MaxQueue() {
            queue = new ArrayDeque<>();
            maxQueue = new ArrayDeque<>();
        }

        public int max_value() {
            if (maxQueue.isEmpty()) return -1;
            return maxQueue.peekFirst();
        }

        public void push_back(int value) {
            queue.offerLast(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.pollLast();
            }
            maxQueue.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty() || maxQueue.isEmpty()) {
                return -1;
            }
            Integer value = queue.pollFirst();
            if (value.equals(maxQueue.peekFirst())) {
                maxQueue.pollFirst();
            }
            return value;
        }
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        MaxQueue queue = new MaxQueue();
    }
}
