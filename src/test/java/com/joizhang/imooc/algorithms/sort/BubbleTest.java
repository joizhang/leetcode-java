package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void sortGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10, 0, 100);
        Bubble.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortMoreGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10000, 100, 100000);
        Bubble.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}