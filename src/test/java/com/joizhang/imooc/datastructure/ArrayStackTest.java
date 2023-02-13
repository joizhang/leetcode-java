package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void testArrayStack() {
        Stack<Integer> stack = new ArrayStack<>();
        assertTrue(stack.isEmpty());
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertFalse(stack.isEmpty());
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
        assertTrue(stack.isEmpty());
    }

}