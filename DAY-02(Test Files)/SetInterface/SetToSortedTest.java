package com.day2.collections.SetInterface;

import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class SetToSortedTest {

    @Test
    public void testConvertToSortedList() {
        // Test case: Convert HashSet to sorted list
        Set<Integer> set = new HashSet<>();
        set.add(5);
        set.add(3);
        set.add(9);
        set.add(1);

        // Expected sorted list
        List<Integer> expectedSortedList = Arrays.asList(1, 3, 5, 9);

        // Convert set to sorted list and verify
        assertEquals(expectedSortedList, SetToSortedList.convertToSortedList(set));
    }
}
