package com.day2.collections.MapInterface;

import java.util.*;

public class InvertMap{

    // Method to invert the map
    public static <K, V> Map<V, List<K>> invertMap(Map<K, V> originalMap) {
        Map<V, List<K>> invertedMap = new HashMap<>();

        // Iterate through the original map and invert key-value pairs
        for (Map.Entry<K, V> entry : originalMap.entrySet()) {
            V value = entry.getValue();
            K key = entry.getKey();

            // If the value already exists in the inverted map, add the key to the list
            invertedMap.computeIfAbsent(value, k -> new ArrayList<>()).add(key);
        }

        return invertedMap;
    }

    // Main method for running the code
    public static void main(String[] args) {
        // Example input
        Map<String, Integer> originalMap = new HashMap<>();
        originalMap.put("A", 1);
        originalMap.put("B", 2);
        originalMap.put("C", 1);

        // Invert the map
        Map<Integer, List<String>> invertedMap = invertMap(originalMap);

        // Print the inverted map
        System.out.println(invertedMap);
    }
}
