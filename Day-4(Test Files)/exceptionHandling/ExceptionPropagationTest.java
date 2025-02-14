package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class ExceptionPropagationTest {

    @Test
    public void testExceptionPropagation() {
        // Capture the output of the program (System.out)
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Call the main method which will propagate the exception
        try {
            ExceptionPropagation.main(new String[]{});
        } catch (Exception e) {

        }

        // Verify that the expected exception handling message is printed
        String output = outputStream.toString().trim();
        assertEquals("Handled exception in main", output);
    }
}
