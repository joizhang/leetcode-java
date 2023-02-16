package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

public class SortCompareTest {

    @Test
    public void compareWithRandomArray() {
        SortCompare.compareWithRandomArray(
                50000,
                Sorts.SortType.BUBBLE,
                Sorts.SortType.SELECTION,
                Sorts.SortType.INSERTION,
                Sorts.SortType.SHELL,
                Sorts.SortType.MERGE,
                Sorts.SortType.QUICK/*,
                Sorts.SortType.HEAP*/
        );
    }

    @Test
    public void compareWithNearlyOrderedArray() {
        SortCompare.compareWithNearlyOrderedArray(
                100000,
                Sorts.SortType.BUBBLE,
                Sorts.SortType.SELECTION,
                Sorts.SortType.INSERTION,
                Sorts.SortType.SHELL,
                Sorts.SortType.MERGE,
                Sorts.SortType.QUICK/*,
                Sorts.SortType.HEAP*/
        );
    }

}