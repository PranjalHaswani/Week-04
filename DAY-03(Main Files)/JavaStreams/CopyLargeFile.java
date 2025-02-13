package com.day3.JavaStreams;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CopyLargeFile {

    private static final int BUFFER_SIZE = 4096;

    public static void main(String[] args) throws IOException {
        String sourceFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\LargeFile.txt";
        String destinationFileBufferedPath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\DestinationFileBuffer.txt";
        String destinationFileUnbufferedPath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\DestinationFileUnbuffer.txt";

        // Create test files (large file)
        generateLargeFile(sourceFilePath);

        // Measure the time for Buffered copy
        long startTimeBuffered = System.nanoTime();
        copyFileBuffered(sourceFilePath, destinationFileBufferedPath);
        long endTimeBuffered = System.nanoTime();
        System.out.println("Buffered copy took: " + (endTimeBuffered - startTimeBuffered) + " ns");

        // Measure the time for Unbuffered copy
        long startTimeUnbuffered = System.nanoTime();
        copyFileUnbuffered(sourceFilePath, destinationFileUnbufferedPath);
        long endTimeUnbuffered = System.nanoTime();
        System.out.println("Unbuffered copy took: " + (endTimeUnbuffered - startTimeUnbuffered) + " ns");

    }

    // Method to copy using Buffered Streams
    static void copyFileBuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFilePath));
             BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destinationFilePath))) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to copy using Unbuffered Streams
    static void copyFileUnbuffered(String sourceFilePath, String destinationFilePath) throws IOException {
        try (FileInputStream fis = new FileInputStream(sourceFilePath);
             FileOutputStream fos = new FileOutputStream(destinationFilePath)) {

            byte[] buffer = new byte[BUFFER_SIZE];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
        }
    }

    // Method to generate a large test file (100MB)
    private static void generateLargeFile(String filePath) throws IOException {
        try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath))) {
            byte[] data = new byte[BUFFER_SIZE]; // 4 KB buffer
            for (int i = 0; i < 100 * 1024; i++) { // 100 MB / 4 KB = 25,600 iterations
                bos.write(data);
            }
        }
    }
}

