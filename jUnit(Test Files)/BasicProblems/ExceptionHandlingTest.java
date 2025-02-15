package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class ExceptionHandlingTest {

    // Test case to check if ArithmeticException is thrown when dividing by 0
    @Test
    public void testDivideByZero() {
        ExceptionHandling calculator = new ExceptionHandling();

        // Assert that an ArithmeticException is thrown when dividing by zero
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(10, 0);
        });

        // Assert the exception message
        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    // Test case to check division when b is not zero
    @Test
    public void testDivideNormal() {
        ExceptionHandling calculator = new ExceptionHandling();

        // Regular division case
        int result = calculator.divide(10, 2);

        // Assert the result is as expected (10 / 2 = 5)
        assertEquals(5, result);
    }
}
