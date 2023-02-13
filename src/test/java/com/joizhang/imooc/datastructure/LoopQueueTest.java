package com.joizhang.imooc.datastructure;

import org.junit.Test;

public class LoopQueueTest {

    @Test
    public void testQueue() {
        LoopQueue<Integer> queue = new LoopQueue<>(10);
        for (int i = 0; i < 10; i++) {
            queue.offer(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.poll();
                System.out.println(queue);
            }
        }
    }

}