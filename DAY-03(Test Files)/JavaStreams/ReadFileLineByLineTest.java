package com.day3.JavaStreams;

import org.junit.jupiter.api.*;

import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class ReadFileLineByLineTest {

    private static final String TEST_FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\LargeTextFile500Test.txt";

    @BeforeEach
    public void setUp() throws IOException {
        // Create a temporary test file with sample content
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(TEST_FILE_PATH))) {
            writer.write("This is a normal line.\n");
            writer.write("This line contains an ERROR.\n");
            writer.write("Another normal line.\n");
            writer.write("Another error found here.\n");
            writer.write("No error here.\n");
        }
    }

    @Test
    public void testReadFileLineByLine() throws IOException {
        // Redirect System.out to capture printed lines
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        // Call the main method of ReadFileLineByLine
        ReadFileLineByLine.main(new String[]{TEST_FILE_PATH});

        // Verify that the output contains the expected lines with "error"
        String output = outputStream.toString();
        assertTrue(output.contains("Error found: error This is a sample line of text for the large file."));
        assertTrue(output.contains("Error found: This is a sample line of text error  for the large file."));

        // Ensure there are no false positives (i.e., normal lines without "error")
        assertFalse(output.contains("This is a normal line."));
        assertFalse(output.contains("Another normal line."));
        assertFalse(output.contains("No error here."));
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
