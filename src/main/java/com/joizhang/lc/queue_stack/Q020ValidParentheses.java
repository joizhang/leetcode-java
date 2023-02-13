package com.joizhang.lc.queue_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. 有效的括号
 */
public class Q020ValidParentheses {
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else{
                if (c == ')' && (stack.isEmpty() || stack.peek() != '(')) {
                    return false;
                } else if (c == '}' && (stack.isEmpty() || stack.peek() != '{')) {
                    return false;
                } else if (c == ']' && (stack.isEmpty() || stack.peek() != '[')) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Q020ValidParentheses test = new Q020ValidParentheses();
        System.out.println(test.isValid("()"));
        System.out.println(test.isValid("()[]{}"));
        System.out.println(test.isValid("(]"));
    }
}
