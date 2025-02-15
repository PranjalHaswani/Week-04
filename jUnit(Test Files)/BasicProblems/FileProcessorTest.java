package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.IOException;

public class FileProcessorTest {

    private FileProcessor fileProcessor;
    private String filename = "file.txt";
    private String content = "Hello, this is a test.";

    @BeforeEach
    public void setUp() {
        fileProcessor = new FileProcessor();
    }

    // Test to check if the content is written and read correctly
    @Test
    public void testWriteAndReadContent() throws IOException {
        fileProcessor.writeToFile(filename, content);

        // Read back the content from the file
        String readContent = fileProcessor.readFromFile(filename);

        assertEquals(content, readContent.trim(), "The content read from the file should be the same as the written content.");
    }

    // Test to check if the file exists after writing content
    @Test
    public void testFileExistsAfterWriting() throws IOException {
        fileProcessor.writeToFile(filename, content);

        // Check if the file exists
        File file = new File(filename);
        assertTrue(file.exists(), "The file should exist after writing to it.");

        // Clean up the file after the test
        file.delete();
    }

    // Test to check handling of IOException when the file does not exist
    @Test
    public void testIOExceptionWhenFileNotExist() {
        // Try reading from a file that doesn't exist
        assertThrows(IOException.class, () -> {
            fileProcessor.readFromFile("nonExistentFile.txt");
        }, "An IOException should be thrown when reading from a non-existent file.");
    }

    // Clean up the test file after each test (if the file is created)
    @Test
    public void tearDown() {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }
}
