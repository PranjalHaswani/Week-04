package com.day2.collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoSets {

    // Method to compute the union of two sets
    public static <T> Set<T> union(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        // Add all elements from set2 to result
        result.addAll(set2);
        return result;
    }

    // Method to compute the intersection of two sets
    public static <T> Set<T> intersection(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        // Retain only elements that are in both sets
        result.retainAll(set2);
        return result;
    }

    public static void main(String[] args) {
        // Test with two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Compute the union and intersection
        Set<Integer> unionResult = union(set1, set2);
        Set<Integer> intersectionResult = intersection(set1, set2);

        // Print the results
        System.out.println("Union: " + unionResult);
        System.out.println("Intersection: " + intersectionResult);
    }
}
