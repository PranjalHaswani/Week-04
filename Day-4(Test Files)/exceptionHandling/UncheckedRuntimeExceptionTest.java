package com.day4.exceptionHandling;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class UncheckedRuntimeExceptionTest {

    @Test
    public void testValidDivision() {
        String input = "10\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        UncheckedRuntimeException.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Result: 5"));
    }

    @Test
    public void testDivisionByZero() {
        String input = "10\n0\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        UncheckedRuntimeException.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Divisible by zero is not allowed."));
    }

    @Test
    public void testNonNumericInput() {
        String input = "ten\n2\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        UncheckedRuntimeException.main(new String[0]);

        String output = outputStream.toString();
        assertTrue(output.contains("Error: Please enter valid numbers."));
    }
}
