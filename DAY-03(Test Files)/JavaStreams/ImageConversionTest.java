package com.day3.JavaStreams;

import java.io.*;
import java.nio.file.*;
import java.util.Arrays;

public class ImageConversionTest {

    // Method to compare two files byte by byte
    public static boolean areFilesIdentical(String file1, String file2) throws IOException {
        byte[] file1Bytes = Files.readAllBytes(Paths.get(file1));
        byte[] file2Bytes = Files.readAllBytes(Paths.get(file2));
        return Arrays.equals(file1Bytes, file2Bytes);
    }

    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\CollegeImageTest.jpg";
        String outputImagePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\CollegeImageTest - Copy.jpg";

        try {
            // Perform the conversion using ImageConversion class
            ImageConversion.main(new String[]{inputImagePath, outputImagePath});

            // Test if the original and the converted image are identical
            if (areFilesIdentical(inputImagePath, outputImagePath)) {
                System.out.println("The images are identical.");
            } else {
                System.out.println("The images are not identical.");
            }
        } catch (IOException e) {
            System.err.println("IOException occurred during the test: " + e.getMessage());
        }
    }
}
