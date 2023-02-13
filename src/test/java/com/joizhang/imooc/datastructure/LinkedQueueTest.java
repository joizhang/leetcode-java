package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class LinkedQueueTest {

    @Test
    public void testLinkedQueue() {
        Queue<Integer> queue = new LinkedQueue<>();
        assertTrue(queue.isEmpty());
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);
        assertFalse(queue.isEmpty());
        assertEquals(3, queue.getSize());
        assertEquals(Integer.valueOf(1), queue.peek());
        assertEquals(Integer.valueOf(1), queue.poll());
        assertEquals(Integer.valueOf(2), queue.poll());
        assertEquals(Integer.valueOf(3), queue.poll());
        assertTrue(queue.isEmpty());
    }

}