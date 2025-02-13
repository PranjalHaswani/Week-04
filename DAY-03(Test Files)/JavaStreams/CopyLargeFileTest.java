package com.day3.JavaStreams;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyLargeFileTest {

    @Test
    public void testBufferedVsUnbufferedCopy() throws IOException {
        String sourceFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\LargeFileTest.txt";
        String destinationBufferedPath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\DestinationFileBufferTest.txt";
        String destinationUnbufferedPath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\DestinationFileUnbuffer.txt";

        // Generate a large test file (100MB)
        generateLargeFile(sourceFilePath);

        // Measure time for Buffered copy
        long startTimeBuffered = System.nanoTime();
        CopyLargeFile.copyFileBuffered(sourceFilePath, destinationBufferedPath);
        long endTimeBuffered = System.nanoTime();
        long bufferedTime = endTimeBuffered - startTimeBuffered;

        // Measure time for Unbuffered copy
        long startTimeUnbuffered = System.nanoTime();
        CopyLargeFile.copyFileUnbuffered(sourceFilePath, destinationUnbufferedPath);
        long endTimeUnbuffered = System.nanoTime();
        long unbufferedTime = endTimeUnbuffered - startTimeUnbuffered;

        // Output the results
        System.out.println("Buffered copy took: " + bufferedTime + " ns");
        System.out.println("Unbuffered copy took: " + unbufferedTime + " ns");

        // Assert that the buffered copy should be faster than the unbuffered copy
        assertTrue(bufferedTime < unbufferedTime, "Buffered copy should be faster than unbuffered copy.");

        // Verify the content of both destination files (they should be identical)
        verifyFilesAreEqual(sourceFilePath, destinationBufferedPath);
        verifyFilesAreEqual(sourceFilePath, destinationUnbufferedPath);

        // Clean up the test files
        Files.delete(Paths.get(destinationBufferedPath));
        Files.delete(Paths.get(destinationUnbufferedPath));
    }

    private void generateLargeFile(String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] data = new byte[4096]; // 4 KB buffer
            for (int i = 0; i < 100 * 1024; i++) { // 100 MB / 4 KB = 25,600 iterations
                bos.write(data);
            }
        }
    }

    private void verifyFilesAreEqual(String sourceFilePath, String destinationFilePath) throws IOException {
        try (BufferedInputStream sourceStream = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedInputStream destinationStream = new BufferedInputStream(new FileInputStream(destinationFilePath))) {

            int sourceByte, destinationByte;
            while ((sourceByte = sourceStream.read()) != -1 && (destinationByte = destinationStream.read()) != -1) {
                assertEquals(sourceByte, destinationByte, "The files' content should be identical.");
            }
        }
    }
}

