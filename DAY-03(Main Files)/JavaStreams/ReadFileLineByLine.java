package com.day3.JavaStreams;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFileLineByLine {

    public static void main(String[] args) {
        // Specify the file path here
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\LargeTextFile500.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Trim any leading/trailing whitespace
                line = line.trim();



                // Check if the line contains the word "error"
                if (line.toLowerCase().contains("error")) {
                    System.out.println("Error found: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}