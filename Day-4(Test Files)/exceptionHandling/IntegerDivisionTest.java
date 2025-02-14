package com.day4.exceptionHandling;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

class IntegerDivisionTest {

    // Test for valid division (10 / 2)
    @Test
    void testValidDivision() {
        // Call the divide method with valid input
        String result = IntegerDivision.divide(10, 2);

        // Check if the result is correct
        assertEquals("Result: 5", result);
    }

    // Test for division by zero (10 / 0)
    @Test
    void testDivisionByZero() {
        // Call the divide method with a denominator of zero
        String result = IntegerDivision.divide(10, 0);

        // Check if the result is the expected error message
        assertEquals("Error: Cannot divide by zero.", result);
    }
}
