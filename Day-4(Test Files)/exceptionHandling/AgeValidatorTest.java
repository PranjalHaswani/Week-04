package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class AgeValidatorTest {

    @Test
    public void testAgeAbove18() {
        String input = "20\n"; // age >= 18
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AgeValidator.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Access granted!"));
    }

    @Test
    public void testAgeBelow18() {
        String input = "16\n"; // age < 18
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AgeValidator.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Age must be 18 or above"));
    }

    @Test
    public void testAgeBoundary18() {
        String input = "18\n"; // age == 18
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        AgeValidator.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Access granted!"));
    }
}
