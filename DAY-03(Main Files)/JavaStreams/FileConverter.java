package com.day3.JavaStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileConverter {

    public static void main(String[] args) {
        // Source file path
        String sourceFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\SourceFile.txt";
        // Destination file path
        String destinationFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\FileConverterDestinationFile.txt";

        // Convert file contents from uppercase to lowercase
        convertFileToLowercase(sourceFilePath, destinationFilePath);
    }

    public static void convertFileToLowercase(String sourceFilePath, String destinationFilePath) {
        try (
                // Create BufferedReader to read the source file with UTF-8 encoding
                BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(sourceFilePath), StandardCharsets.UTF_8));

                // Create BufferedWriter to write to the destination file with UTF-8 encoding
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(destinationFilePath), StandardCharsets.UTF_8))
        ) {
            String line;

            // Read each line from the source file, convert to lowercase, and write to the destination file
            while ((line = reader.readLine()) != null) {
                writer.write(line.toLowerCase());
                writer.newLine();
            }

            System.out.println("File contents have been converted to lowercase and saved to: " + destinationFilePath);

        } catch (IOException e) {
            System.out.println("Error during file processing: " + e.getMessage());
        }
    }
}
