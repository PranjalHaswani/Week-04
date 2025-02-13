package com.day3.JavaStreams;
import org.junit.jupiter.api.*;
import java.io.*;
import java.nio.file.*;

import static org.junit.jupiter.api.Assertions.*;

public class FileCopyTest {

    private static final String SOURCE_FILE_PATH = "src/test/resources/File1Test.txt";
    private static final String DESTINATION_FILE_PATH = "src/test/resources/DestinationFileTest.txt";

    private File sourceFile;
    private File destinationFile;

    @BeforeEach
    public void setUp() throws IOException {
        // Create the source file with some content for testing
        sourceFile = new File(SOURCE_FILE_PATH);
        if (!sourceFile.exists()) {
            // Create directories if they don't exist
            Files.createDirectories(Paths.get("src/test/resources"));

            // Write content to the source file
            try (FileWriter writer = new FileWriter(sourceFile)) {
                writer.write("Hello Everyone. Hope You are doing well. Have a beautiful day ahead.");
            }
        }

        // Create the destination file, in case it exists from previous tests
        destinationFile = new File(DESTINATION_FILE_PATH);
    }

    @Test
    public void testFileCopy() throws IOException {
        // Run the file copy process
        FileCopy.main(new String[]{SOURCE_FILE_PATH, DESTINATION_FILE_PATH});

        // Verify that the destination file is created
        assertTrue(destinationFile.exists(), "Destination file should be created.");

        // Verify that the content is the same in both source and destination
        try (BufferedReader sourceReader = new BufferedReader(new FileReader(sourceFile));
             BufferedReader destinationReader = new BufferedReader(new FileReader(destinationFile))) {

            String sourceLine, destinationLine;
            while ((sourceLine = sourceReader.readLine()) != null && (destinationLine = destinationReader.readLine()) != null) {
                assertEquals(sourceLine, destinationLine, "The content of the files should be the same.");
            }
        }
    }

    @AfterEach
    public void tearDown() {
        // Do not delete the source and destination files after the test
        // Leaving them intact for further inspection if needed.
    }
}
