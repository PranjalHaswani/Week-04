package com.day3.JavaStreams;

import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.jupiter.api.Assertions.*;

public class FileConverterTest {

    private static final String SOURCE_FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\SourceFileTest.txt";
    private static final String DESTINATION_FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\FileConverterDestinationFileTest.txt";

    private File sourceFile;
    private File destinationFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create a source file with some uppercase content for testing
        sourceFile = new File(SOURCE_FILE_PATH);
        if (!sourceFile.exists()) {
            Files.createDirectories(Paths.get("src/test/resources"));
            try (FileWriter writer = new FileWriter(sourceFile)) {
                writer.write("Hello, EVeRyOne, Hope you all are doing well. Have a nice DAY Ahead.");
            }
        }

        // Ensure the destination file does not already exist before starting the test
        destinationFile = new File(DESTINATION_FILE_PATH);
        if (destinationFile.exists()) {
            destinationFile.delete();
        }
    }

    @Test
    public void testFileConversionToLowercase() throws IOException {
        // Run the file conversion process
        FileConverter.convertFileToLowercase(SOURCE_FILE_PATH, DESTINATION_FILE_PATH);

        // Verify that the destination file is created
        assertTrue(destinationFile.exists(), "Destination file should be created.");

        // Verify the contents of the destination file are in lowercase
        try (BufferedReader reader = new BufferedReader(new FileReader(destinationFile))) {
            String line = reader.readLine();
            assertEquals("hello, everyone, hope you all are doing well. have a nice day ahead.", line, "The content of the file should be in lowercase.");
        }
    }

    @AfterEach
    public void tearDown() {
        // Clean up the source and destination files after the test
        if (sourceFile.exists()) {
            sourceFile.delete();
        }
        if (destinationFile.exists()) {
            destinationFile.delete();
        }
    }
}
