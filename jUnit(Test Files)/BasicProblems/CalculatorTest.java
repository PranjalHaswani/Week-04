package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        assertEquals(8, calculator.add(5, 3), "5 + 3 should equal 8");
    }

    @Test
    void testSubtract() {
        assertEquals(2, calculator.subtract(5, 3), "5 - 3 should equal 2");
    }

    @Test
    void testMultiply() {
        assertEquals(15, calculator.multiply(5, 3), "5 * 3 should equal 15");
    }

    @Test
    void testDivide() {
        assertEquals(2.5, calculator.divide(5, 2), "5 / 2 should equal 2.5");
    }

    @Test
    void testDivideByZero() {
        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            calculator.divide(5, 0);
        });
        assertEquals("Cannot divide by zero", exception.getMessage());
    }
}
