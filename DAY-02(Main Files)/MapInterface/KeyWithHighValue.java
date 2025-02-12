package com.day2.collections.MapInterface;

import java.util.*;

public class KeyWithHighValue {

    // Method to find the key with the maximum value in the map
    public static String getKeyWithMaxValue(Map<String, Integer> map) {
        // If the map is empty, return null or handle as needed
        if (map == null || map.isEmpty()) {
            return null;
        }

        // Initialize a variable to store the key with the maximum value
        String maxKey = null;
        int maxValue = Integer.MIN_VALUE;

        // Iterate through the map entries
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxValue) {
                maxValue = entry.getValue();
                maxKey = entry.getKey();
            }
        }

        return maxKey;
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Example input map
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);

        // Find and print the key with the maximum value
        String keyWithMaxValue = getKeyWithMaxValue(map);
        System.out.println("Key with the maximum value: " + keyWithMaxValue);
    }
}
