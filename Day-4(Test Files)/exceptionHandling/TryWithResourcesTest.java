package com.day4.exceptionHandling;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcesTest {

    @Test
    public void testFileExists() throws IOException {
        // Set up a temporary file and write a test line to it
        String fileName = "info.txt";
        String expectedLine = "This is the first line of the file.";

        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName))) {
            writer.write(expectedLine);
        }

        // Capture the output of the program
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the method to test the file reading
        TryWithResources.readFirstLine(fileName);

        // Verify the output contains the expected first line
        String output = outputStream.toString().trim();
        assertEquals(expectedLine, output);

        // Clean up: delete the temporary file after testing
        Files.delete(Paths.get(fileName));
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Set up an empty file
        String fileName = "empty.txt";

        Files.createFile(Paths.get(fileName));

        // Capture the output of the program
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Run the method to test the empty file case
        TryWithResources.readFirstLine(fileName);

        // Verify the output indicates the file is empty
        String output = outputStream.toString().trim();
        assertEquals("File is empty.", output);

        // Clean up: delete the empty file after testing
        Files.delete(Paths.get(fileName));
    }
}
