package com.day2.collections.SetInterface;

import java.util.*;

public class FindSubsets {

    // Method to check if set1 is a subset of set2
    public static <T> boolean isSubset(Set<T> set1, Set<T> set2) {
        // Returns true if set2 contains all elements of set1
        return set2.containsAll(set1);
    }

    public static void main(String[] args) {
        // Test case
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Check if set1 is a subset of set2
        boolean result = isSubset(set1, set2);

        // Output the result
        System.out.println("Is set1 a subset of set2? " + result);
    }
}
