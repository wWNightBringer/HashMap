package com.night.service;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomHashMapTest {
    private CustomHashMap customHashMap;

    @BeforeEach
    public void init() {
        customHashMap = new CustomHashMap();
        customHashMap.put(1, 3L);
        customHashMap.put(2, 4L);
    }

    @Test
    void put() {
        customHashMap.put(7, 10L);
        Integer expect = 3;
        Assert.assertEquals(expect, customHashMap.size());
        customHashMap.put(7, 11L);
        expect = 4;
        Assert.assertEquals(expect, customHashMap.size());
        customHashMap.put(7, 120L);
        expect = 5;
        Assert.assertEquals(expect, customHashMap.size());
    }

    @org.junit.jupiter.api.Test
    void get() {
        Long expect = 3L;
        Assert.assertEquals(expect, customHashMap.get(1));
        Long unexpected = 5L;
        Assert.assertNotEquals(unexpected, customHashMap.get(2));
    }


}