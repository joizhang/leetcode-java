package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeBUTest {

    @Test
    public void testSort() {
        Integer[] integers = Sorts.generateRandomArray(100, 0, 100);
        MergeBU.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}