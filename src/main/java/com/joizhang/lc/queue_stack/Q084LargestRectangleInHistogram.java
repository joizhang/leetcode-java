package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 84. Largest Rectangle in Histogram
 */
public class Q084LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length, ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int i = 0;
        while (i < n) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                int area = heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1));
                ans = Math.max(ans, area);
            }
            stack.push(i++);
        }

        while (!stack.isEmpty()) {
            int area = heights[stack.pop()] * (i - (stack.isEmpty() ? 0 : stack.peek() + 1));
            ans = Math.max(ans, area);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q084LargestRectangleInHistogram test = new Q084LargestRectangleInHistogram();
        System.out.println(test.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
        System.out.println(test.largestRectangleArea(new int[]{2, 4}));
    }
}
