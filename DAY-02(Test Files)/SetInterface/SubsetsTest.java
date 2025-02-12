package com.day2.collections.SetInterface;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SubsetsTest {

    @Test
    public void testIsSubsetTrue() {
        // Test case: set1 is a subset of set2
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.add(2);
        set1.add(3);

        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);

        // Assert that set1 is a subset of set2
        assertTrue(FindSubsets.isSubset(set1, set2));
    }
}
