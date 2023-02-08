package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    @Test
    public void testHashMap() {
        Map<String, String> map = new HashMap<>();
        char a = 'a';
        for (int i = 0; i < 26; i++) {
            String s = String.valueOf(a++);
            map.put(s, s);
        }
        assertEquals(26, map.getSize());
        assertFalse(map.isEmpty());
        System.out.println(map);
    }

}