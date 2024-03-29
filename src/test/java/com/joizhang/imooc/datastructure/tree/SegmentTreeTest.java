package com.joizhang.imooc.datastructure.tree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SegmentTreeTest {

    @Test
    public void segmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, new Merger<Integer>() {
            @Override
            public Integer merge(Integer a, Integer b) {
                return a + b;
            }
        });
        System.out.println(segmentTree);
    }

    @Test
    public void query() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segmentTree = new SegmentTree<>(nums, (a, b) -> a + b);
        assertEquals(Integer.valueOf(1), Integer.valueOf(segmentTree.query(0, 2).toString()));
        assertEquals(Integer.valueOf(-1), Integer.valueOf(segmentTree.query(2, 5).toString()));
        assertEquals(Integer.valueOf(-3), Integer.valueOf(segmentTree.query(0, 5).toString()));
    }

}