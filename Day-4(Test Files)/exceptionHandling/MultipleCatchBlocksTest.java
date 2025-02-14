package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class MultipleCatchBlocksTest {

    @Test
    public void testValidIndex() {
        String input = "5\n1\n2\n3\n4\n5\n2\n"; // Array: [1, 2, 3, 4, 5], Index: 2
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MultipleCatchBlocks.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Value at index 2: 3"));
    }

    @Test
    public void testInvalidIndex() {
        String input = "5\n1\n2\n3\n4\n5\n10\n"; // Array: [1, 2, 3, 4, 5], Invalid Index: 10
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        MultipleCatchBlocks.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Invalid index!"));
    }
}
