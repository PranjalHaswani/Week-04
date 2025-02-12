package com.day2.collections.MapInterface;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class FrequencyCounterTest {

    private File tempFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary file for testing
        tempFile = File.createTempFile("testfile", ".txt");

        // Write some test content into the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("Hello world, hello Java!");
        }
    }

    @AfterEach
    public void tearDown() {
        // Delete the temporary file after the test
        tempFile.delete();
    }

    @Test
    public void testWordFrequencies() throws IOException {
        // Test the countWordFrequencies method with the temporary file
        Map<String, Integer> wordFrequencies = FrequencyCounter.countWordFrequencies(tempFile.getAbsolutePath());

        // Check if the word frequencies are correct
        Map<String, Integer> expected = new HashMap<>();
        expected.put("hello", 2);
        expected.put("world", 1);
        expected.put("java", 1);

        assertEquals(expected, wordFrequencies);
    }

    @Test
    public void testEmptyFile() throws IOException {
        // Test with an empty file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write("");
        }

        Map<String, Integer> wordFrequencies = FrequencyCounter.countWordFrequencies(tempFile.getAbsolutePath());

        // Check if the result is an empty map
        assertTrue(wordFrequencies.isEmpty());
    }

    @Test
    public void testFileWithNoWords() throws IOException {
        // Test with a file containing no words (only punctuation)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
            writer.write(",,, !!! --- ? ?");
        }

        Map<String, Integer> wordFrequencies = FrequencyCounter.countWordFrequencies(tempFile.getAbsolutePath());

        // Check if the result is an empty map
        assertTrue(wordFrequencies.isEmpty());
    }
}
