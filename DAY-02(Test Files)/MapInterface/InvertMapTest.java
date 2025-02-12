package com.day2.collections.MapInterface;

import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class InvertMapTest {

    @Test
    public void testInvertMap() {
        // Create the original map
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Expected inverted map
        Map<Integer, List<String>> expectedMap = new HashMap<>();
        expectedMap.put(1, Arrays.asList("A", "C"));
        expectedMap.put(2, Arrays.asList("B"));

        // Invert the map
        Map<Integer, List<String>> invertedMap = InvertMap.invertMap(originalMap);

        // Check if the inverted map matches the expected map
        assertEquals(expectedMap, invertedMap);
    }
}
