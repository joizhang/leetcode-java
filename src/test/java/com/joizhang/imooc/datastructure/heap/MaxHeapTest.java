package com.joizhang.imooc.datastructure.heap;

import com.joizhang.imooc.datastructure.ArrayList;
import com.joizhang.imooc.datastructure.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxHeapTest {

    @Test
    public void testMaxHeap() {
        Heap<Integer> heap = new MaxHeap<>();
        for (int i = 0; i < 100; i++) {
            heap.add(i);
        }
        assertFalse(heap.isEmpty());
        assertEquals(100, heap.size());

        List<Integer> list = new ArrayList<>();
        while (!heap.isEmpty()) {
            list.addLast(heap.extractElement());
        }
        for (int i = 0; i < list.getSize() - 1; i++) {
            assertTrue(list.get(i) > list.get(i + 1));
        }
    }

}