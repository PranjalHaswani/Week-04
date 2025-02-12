package com.day2.collections.MapInterface;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class MergeTest {

    @Test
    public void testMergeMaps() {
        // Create the first map
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        // Create the second map
        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = MergeTwoMaps.mergeMaps(map1, map2);

        // Expected merged map
        Map<String, Integer> expectedMap = new HashMap<>();
        expectedMap.put("A", 1);
        expectedMap.put("B", 5);
        expectedMap.put("C", 4);

        // Verify the merged map
        assertEquals(expectedMap, mergedMap);
    }
}

