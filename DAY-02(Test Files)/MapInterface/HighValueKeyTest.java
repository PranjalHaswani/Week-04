package com.day2.collections.MapInterface;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class HighValueKeyTest {

    @Test
    public void testGetKeyWithMaxValue() {
        // Create the input map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Expected output: B, because B has the highest value (20)
        String result = KeyWithHighValue.getKeyWithMaxValue(map);
        assertEquals("B", result);
    }
}