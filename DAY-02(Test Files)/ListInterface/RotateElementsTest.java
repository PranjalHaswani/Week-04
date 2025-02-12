package com.day2.collections.ListInterface;

import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class RotateElementsTest {

    @Test
    public void testRotateList() {
        // Test case: rotate by 2 positions
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        List<Integer> result = RotateElements.rotateList(inputList, 2);

        // Verify the rotation result
        assertEquals(List.of(30, 40, 50, 10, 20), result);
    }

    @Test
    public void testRotateListMoreThanSize() {
        // Test case: rotate by more than the size of the list
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        List<Integer> result = RotateElements.rotateList(inputList, 7); // 7 % 5 = 2

        // Verify the rotation result
        assertEquals(List.of(30, 40, 50, 10, 20), result);
    }

    @Test
    public void testRotateListZero() {
        // Test case: rotate by 0 positions (no change)
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        List<Integer> result = RotateElements.rotateList(inputList, 0);

        // Verify the result (should be unchanged)
        assertEquals(inputList, result);
    }

    @Test
    public void testRotateListEmpty() {
        // Test case: empty list (no change)
        List<Integer> inputList = List.of();
        List<Integer> result = RotateElements.rotateList(inputList, 3);

        // Verify the result (should be empty)
        assertTrue(result.isEmpty());
    }

    @Test
    public void testRotateListSingleElement() {
        // Test case: list with a single element (no change)
        List<Integer> inputList = List.of(100);
        List<Integer> result = RotateElements.rotateList(inputList, 3);

        // Verify the result (should be unchanged)
        assertEquals(inputList, result);
    }
}
