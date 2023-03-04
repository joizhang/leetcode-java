package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * 239. 滑动窗口最大值
 */
public class Q239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) return new int[0];
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < k; i++) {
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
        }
        int index = 0;
        res[index++] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {
            // index++表示窗口已经移动，需要判断队首元素是否是刚刚移出窗口的元素
            if (nums[i - k] == deque.peekFirst()) {
                deque.pollFirst();
            }
            while (!deque.isEmpty() && nums[i] > deque.peekLast()) {
                deque.pollLast();
            }
            deque.offerLast(nums[i]);
            res[index++] = deque.peekFirst();

        }
        return res;
    }

    public static void main(String[] args) {
        Q239SlidingWindowMaximum test = new Q239SlidingWindowMaximum();
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(test.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
