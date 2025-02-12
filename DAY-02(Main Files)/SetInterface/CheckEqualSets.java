package com.day2.collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class CheckEqualSets {

    // Method to check if two sets are equal
    public static <T> boolean areSetsEqual(Set<T> set1, Set<T> set2) {
        return set1.equals(set2);
    }

    public static void main(String[] args) {
        // Test with two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Check if the sets are equal
        boolean result = areSetsEqual(set1, set2);
        System.out.println(result);
    }
}
