package com.day2.collections.SetInterface;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class SymmetricDifferenceTest {

    @Test
    public void testSymmetricDifference() {
        // Test case: Symmetric difference of two sets
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(4);
        set2.add(5);

        // Expected symmetric difference: {1, 2, 4, 5}
        Set<Integer> expectedSymmetricDifference = new HashSet<>();
        expectedSymmetricDifference.add(1);
        expectedSymmetricDifference.add(2);
        expectedSymmetricDifference.add(4);
        expectedSymmetricDifference.add(5);

        assertEquals(expectedSymmetricDifference, SymmetricDifference.symmetricDifference(set1, set2));
    }
}
