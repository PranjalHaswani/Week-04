package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InterestCalculatorTest {

    @Test
    public void testValidInput() {
        // Test with valid input
        double amount = 1000;
        double rate = 5;
        int years = 3;

        // Calculate expected interest
        double expectedInterest = (1000 * 5 * 3) / 100;

        // Call the method and check the result
        try {
            double interest = InterestCalculator.calculateInterest(amount, rate, years);
            assertEquals(expectedInterest, interest, "Interest calculation should be correct");
        } catch (IllegalArgumentException e) {
            fail("Exception should not be thrown for valid input");
        }
    }

    @Test
    public void testNegativeAmount() {
        // Test with negative amount
        double amount = -1000;
        double rate = 3;
        int years = 2;

        // Call the method and check if the exception is thrown
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InterestCalculator.calculateInterest(amount, rate, years);
        });

        assertEquals("Amount and rate must be positive", thrown.getMessage());
    }

    @Test
    public void testNegativeRate() {
        // Test with negative rate
        double amount = 1000;
        double rate = -5;
        int years = 3;

        // Call the method and check if the exception is thrown
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InterestCalculator.calculateInterest(amount, rate, years);
        });

        assertEquals("Amount and rate must be positive", thrown.getMessage());
    }

    @Test
    public void testNegativeAmountAndRate() {
        // Test with negative amount and rate
        double amount = -1000;
        double rate = -5;
        int years = 3;

        // Call the method and check if the exception is thrown
        IllegalArgumentException thrown = assertThrows(IllegalArgumentException.class, () -> {
            InterestCalculator.calculateInterest(amount, rate, years);
        });

        assertEquals("Amount and rate must be positive", thrown.getMessage());
    }
}
