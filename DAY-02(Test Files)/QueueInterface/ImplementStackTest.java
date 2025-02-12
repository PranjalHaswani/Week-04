package com.day2.collections.QueueInterface;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ImplementStackTest {

    @Test
    public void testStackOperations() {
        // Create a new ImplementStack instance
        ImplementStack stack = new ImplementStack();

        // Push elements onto the stack
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Test the top() method
        assertEquals(3, stack.top(), "Top element should be 3");

        // Test the pop() method
        assertEquals(3, stack.pop(), "Popped element should be 3");

        // Test the top() method again after pop
        assertEquals(2, stack.top(), "Top element should be 2");

        // Test popping again
        assertEquals(2, stack.pop(), "Popped element should be 2");

        // Test popping the last element
        assertEquals(1, stack.pop(), "Popped element should be 1");

        // Test if the stack is empty
        assertTrue(stack.empty(), "Stack should be empty now");
    }
}
