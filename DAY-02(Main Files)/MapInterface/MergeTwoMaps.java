package com.day2.collections.MapInterface;

import java.util.*;

public class MergeTwoMaps {

    // Method to merge two maps and sum their values for common keys
    public static Map<String, Integer> mergeMaps(Map<String, Integer> map1, Map<String, Integer> map2) {
        // Create a new map to store the merged result
        Map<String, Integer> mergedMap = new HashMap<>();

        // First, add all entries from map1 to the mergedMap
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            mergedMap.put(entry.getKey(), entry.getValue());
        }

        // Then, add entries from map2 to the mergedMap
        // If a key already exists in mergedMap, sum the values
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            mergedMap.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }

        return mergedMap;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example maps
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        // Merge the maps
        Map<String, Integer> mergedMap = mergeMaps(map1, map2);

        // Print the merged map
        System.out.println("Merged Map: " + mergedMap);
    }
}
