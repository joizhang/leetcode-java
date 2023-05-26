package com.joizhang.lcof;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        if (pushed == null || popped == null) return false;
        if (pushed.length != popped.length) return false;
        Deque<Integer> stack = new ArrayDeque<>();
        int index = 0;
        for (int num : pushed) {
            stack.push(num);
            while (!stack.isEmpty() && stack.peek().equals(popped[index])) {
                stack.pop();
                index++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution test = new Solution();
        System.out.println(test.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(test.validateStackSequences(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }
}
