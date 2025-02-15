package com.day5.JUnit.BasicProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ParameterizedTest {

    private final Parameterized parameterized = new Parameterized();

    // Test to check if the number is even
    @Test
    public void testIsEvenWithEvenNumber() {
        assertTrue(parameterized.isEven(2), "2 should be even.");
        assertTrue(parameterized.isEven(4), "4 should be even.");
    }

    // Test to check if the number is odd (should not be even)
    @Test
    public void testIsEvenWithOddNumber() {
        assertFalse(parameterized.isEven(7), "7 should not be even.");
        assertFalse(parameterized.isEven(9), "9 should not be even.");
    }
}
