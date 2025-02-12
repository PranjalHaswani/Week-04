package com.day2.collections.SetInterface;

import java.util.*;

public class SetToSortedList {

    // Method to convert a HashSet to a sorted list
    public static List<Integer> convertToSortedList(Set<Integer> set) {
        // Convert the set to a list
        List<Integer> list = new ArrayList<>(set);
        // Sort the list in ascending order
        Collections.sort(list);
        return list;
    }

    public static void main(String[] args) {
        // Test with a HashSet of integers
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Convert the set to a sorted list
        List<Integer> sortedList = convertToSortedList(set);

        // Print the sorted list
        System.out.println("Sorted List: " + sortedList);
    }
}
