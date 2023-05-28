package com.joizhang.lcof.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 剑指 Offer 59 - I. 滑动窗口的最大值
 */
public class Offer59I {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        //单调队列，元素从大到小存放
        Deque<Integer> deque = new ArrayDeque<>();
        // 未形成窗口区间
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        // 窗口区间刚形成后，把队列首位值添加到队列中
        int index = 0;
        res[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            res[index++] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Offer59I test = new Offer59I();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
