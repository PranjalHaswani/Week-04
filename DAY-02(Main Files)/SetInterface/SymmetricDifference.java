package com.day2.collections.SetInterface;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {

    // Method to compute the symmetric difference of two sets
    public static <T> Set<T> symmetricDifference(Set<T> set1, Set<T> set2) {
        Set<T> result = new HashSet<>(set1);
        Set<T> intersection = new HashSet<>(set1);
        // Find intersection of set1 and set2
        intersection.retainAll(set2);

        result.addAll(set2);
        // Remove intersection from union (symmetric difference)
        result.removeAll(intersection);

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

        // Compute the symmetric difference
        Set<Integer> symmetricDifferenceResult = symmetricDifference(set1, set2);

        // Print the result
        System.out.println("Symmetric Difference: " + symmetricDifferenceResult);
    }
}
