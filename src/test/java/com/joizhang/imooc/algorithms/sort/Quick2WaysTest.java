package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class Quick2WaysTest {

    @Test
    public void sortRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(100, 0, 100);
        Quick2Ways.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortRandomLessArray() {
        Integer[] integers = Sorts.generateRandomArray(1000000, 0, 10);
        Quick2Ways.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortNearlyOrderedArray() {
        Integer[] integers = Sorts.generateNearlyOrderedArray(10000, 10);
        Quick2Ways.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}