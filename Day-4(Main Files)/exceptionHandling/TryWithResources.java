package com.day4.exceptionHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TryWithResources {

    public static void readFirstLine(String fileName) {
        // Try-with-resources to ensure the file is automatically closed
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String firstLine = reader.readLine();
            if (firstLine != null) {
                // Print the first line if it's available
                System.out.println(firstLine);
            } else {
                System.out.println("File is empty.");
            }
        } catch (IOException e) {
            System.out.println("Error reading file " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String fileName = "info.txt";
        readFirstLine(fileName);
    }
}
