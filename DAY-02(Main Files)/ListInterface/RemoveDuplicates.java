package com.day2.collections.ListInterface;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class RemoveDuplicates {

    // Method to remove duplicates while preserving the order
    public static <T> List<T> removeDuplicates(List<T> inputList) {
        // Use LinkedHashSet to preserve order while removing duplicates
        LinkedHashSet<T> set = new LinkedHashSet<>(inputList);

        // Convert the set back to a list and return it
        return new ArrayList<>(set);
    }

    public static void main(String[] args) {
        // Test the function with an example
        List<Integer> inputList = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> result = removeDuplicates(inputList);

        // Print the result
        System.out.println(result);
    }
}
