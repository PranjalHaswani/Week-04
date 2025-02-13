package com.day3.JavaStreams;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class WordFrequencyCounterTest {

    private static final String TEST_FILE_PATH = "test_file.txt";

    @BeforeEach
    public void setUp() throws IOException {
        // Prepare a test file with some content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("Hello Kajal, Hello Payal, Hello Palak, Hello, Nitin, Hello Jay. Hello Everyone.");
        }
    }

    @Test
    public void testCountWordsAndDisplayTop5() {
        // Test the countWordsAndDisplayTop5 method
        WordFrequencyCounter.countWordsAndDisplayTop5(TEST_FILE_PATH);

        // Create a map of expected word counts
        Map<String, Integer> expectedWordCount = new HashMap<>();
        expectedWordCount.put("hello", 6);
        expectedWordCount.put("kajal", 1);
        expectedWordCount.put("payal", 1);
        expectedWordCount.put("nitin", 1);
        expectedWordCount.put("jay", 1);
        expectedWordCount.put("everyone", 1);
        expectedWordCount.put("palak", 1);

        // Verify the word counts (for testing purposes, we could make this part more automated)
        try (BufferedReader reader = new BufferedReader(new FileReader(TEST_FILE_PATH))) {
            String line;
            Map<String, Integer> actualWordCount = new HashMap<>();

            while ((line = reader.readLine()) != null) {
                String[] words = line.split("\\W+");
                for (String word : words) {
                    if (!word.isEmpty()) {
                        word = word.toLowerCase();
                        actualWordCount.put(word, actualWordCount.getOrDefault(word, 0) + 1);
                    }
                }
            }
            // Assert that the word count map is equal to the expected word count
            assertEquals(expectedWordCount, actualWordCount);
        } catch (IOException e) {
            fail("Error while reading the test file: " + e.getMessage());
        }
    }

    @AfterEach
    public void tearDown() {
        // Clean up the test file after the test
        File file = new File(TEST_FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
