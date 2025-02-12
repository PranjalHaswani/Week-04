package com.day2.collections.SetInterface;

import org.junit.jupiter.api.Test;
import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class EqualSetsTest {

    @Test
    public void testSetsEqual() {
        // Test case: Two sets with the same elements, different order
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(1);
        set1.add(2);
        set1.add(3);

        set2.add(3);
        set2.add(2);
        set2.add(1);

        // Verify that the sets are equal
        assertTrue(CheckEqualSets.areSetsEqual(set1, set2));
    }
}
