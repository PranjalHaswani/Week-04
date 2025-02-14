package com.day4.exceptionHandling;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class NestedTryCatchBlockTest {

    @Test
    public void testValidInput() {
        int[] arr = {10, 20, 30};
        int index = 1;
        int divisor = 2;

        NestedTryCatchBlock obj = new NestedTryCatchBlock();
        // Normally we'd have to mock input for this, but assuming this behavior, we expect:
        assertEquals("Division result: 10", obj.divideElement(arr, index, divisor));
    }

    @Test
    public void testInvalidIndex() {
        int[] arr = {10, 20, 30};
        int index = 5;
        int divisor = 2;

        NestedTryCatchBlock obj = new NestedTryCatchBlock();
        assertEquals("Invalid array index!", obj.divideElement(arr, index, divisor));
    }

    @Test
    public void testDivideByZero() {
        int[] arr = {10, 20, 30};
        int index = 1;
        int divisor = 0;

        NestedTryCatchBlock obj = new NestedTryCatchBlock();
        assertEquals("Cannot divide by zero!", obj.divideElement(arr, index, divisor));
    }
}
