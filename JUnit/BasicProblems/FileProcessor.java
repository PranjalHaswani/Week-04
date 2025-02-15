package com.day5.JUnit.BasicProblems;

import java.io.*;

public class FileProcessor {

    // Method to write content to a file
    public void writeToFile(String filename, String content) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        }
    }

    // Method to read content from a file
    public String readFromFile(String filename) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    public static void main(String[] args) {
        FileProcessor fileProcessor = new FileProcessor();
        String filename = "file.txt";
        String content = "Hello, this is a test.";

        try {
            fileProcessor.writeToFile(filename, content);  // Writing content to file
            System.out.println("File written successfully.");

            String readContent = fileProcessor.readFromFile(filename);  // Reading content from file
            System.out.println("File content: " + readContent);
        } catch (IOException e) {
            System.out.println("Error handling file: " + e.getMessage());
        }
    }
}
