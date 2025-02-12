package com.day2.collections.QueueInterface;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;

public class GenerateBinaryTest {

    @Test
    public void testGenerateBinaryNumbers() {
        // Test case: Generate first 5 binary numbers
        int N = 5;
        List<String> expected = Arrays.asList("1", "10", "11", "100", "101");
        List<String> result = GenerateBinaryNumbers.generateBinaryNumbers(N);

        // Assert that the generated binary numbers match the expected result
        assertEquals(expected, result);
    }
}
