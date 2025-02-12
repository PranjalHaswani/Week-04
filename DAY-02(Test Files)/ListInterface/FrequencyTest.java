package com.day2.collections.ListInterface;

import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

public class FrequencyTest {

    @Test
    public void testCountFrequency() {
        List<String> inputList = List.of("apple", "banana", "apple", "orange");
        Map<String, Integer> result = Frequency.countFrequency(inputList);

        // Verify the frequency of each element
        assertEquals(2, result.get("apple"));
        assertEquals(1, result.get("banana"));
        assertEquals(1, result.get("orange"));
    }

    @Test
    public void testEmptyList() {
        List<String> inputList = List.of();
        Map<String, Integer> result = Frequency.countFrequency(inputList);

        // Verify the result for an empty list
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSingleElementList() {
        List<String> inputList = List.of("apple");
        Map<String, Integer> result = Frequency.countFrequency(inputList);

        // Verify the result for a list with a single element
        assertEquals(1, result.get("apple"));
    }
}
