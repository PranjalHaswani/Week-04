package com.day2.collections.ListInterface;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RemoveDuplicatesTest {

    @Test
    public void testRemoveDuplicates() {
        // Test case: Remove duplicates from a list
        List<Integer> inputList = List.of(3, 1, 2, 2, 3, 4);
        List<Integer> result = RemoveDuplicates.removeDuplicates(inputList);

        // Verify the result (order should be preserved)
        assertEquals(List.of(3, 1, 2, 4), result);
    }
}
