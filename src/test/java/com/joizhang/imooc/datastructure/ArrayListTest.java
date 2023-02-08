package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayListTest {

    @Test
    public void testArrayList() {
        List<Integer> nums = new ArrayList<>();
        nums.addLast(1);
        nums.addLast(2);
        nums.addLast(3);
        System.out.println(nums);
        assertEquals(3, nums.getSize());
        assertFalse(nums.isEmpty());

        nums = new ArrayList<>(new Integer[]{4, 5, 6});
        assertFalse(nums.isEmpty());
        // resize
        nums = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            nums.addLast(i);
        }
        assertEquals(11, nums.getSize());
    }

}