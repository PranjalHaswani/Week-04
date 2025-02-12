package com.day2.collections.ListInterface;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Frequency {

    // Method to count the frequency of elements in the list
    public static Map<String, Integer> countFrequency(List<String> inputList) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String element : inputList) {
            frequencyMap.put(element, frequencyMap.getOrDefault(element, 0) + 1);
        }

        return frequencyMap;
    }

    public static void main(String[] args) {
        // Test the function with an example
        List<String> inputList = List.of("apple", "banana", "apple", "orange");
        Map<String, Integer> result = countFrequency(inputList);

        // Print the result
        System.out.println(result);
    }
}
