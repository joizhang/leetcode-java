package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. Longest Valid Parentheses
 */
public class Q032LongestValidParentheses {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int ans = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                // If current character is '(', push its index to the stack.
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    if (s.charAt(stack.peek()) == '(') {
                        // If current character is ')' and the character at the
                        // index of the top of stack is '(', we just find a
                        // matching pair so pop from the stack.
                        stack.pop();
                    } else {
                        // Otherwise, we push the index of ')' to the stack.
                        stack.push(i);
                    }
                } else {
                    stack.push(i);
                }
            }
        }
        // After the scan is done, the stack will only contain the indices of
        // characters which cannot be matched
        if (stack.isEmpty()) {
            ans = n;
        } else {
            int a = n, b = 0;
            while (!stack.isEmpty()) {
                b = stack.peek();
                stack.pop();
                ans = Math.max(ans, a - b - 1);
                a = b;
            }
            ans = Math.max(ans, a);
        }
        return ans;
    }

    public static void main(String[] args) {
        Q032LongestValidParentheses test = new Q032LongestValidParentheses();
        System.out.println(test.longestValidParentheses("(()"));
    }
}
