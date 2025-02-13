package com.day3.JavaStreams;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    // Method to count words in the file and display the top 5 most frequent words
    public static void countWordsAndDisplayTop5(String filePath) {
        // HashMap to store word counts
        Map<String, Integer> wordCountMap = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Split each line into words and process them
                String[] words = line.split("\\W+");
                for (String word : words) {
                    // Skip empty words
                    if (word.isEmpty()) continue;
                    // Convert to lowercase to handle case insensitivity
                    word = word.toLowerCase();
                    wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                }
            }

            // Sort the words based on frequency in descending order and get the top 5
            List<Map.Entry<String, Integer>> top5Words = wordCountMap.entrySet()
                    .stream()
                    // Sort by value (frequency)
                    .sorted((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()))
                    .limit(5)
                    .collect(Collectors.toList());

            // Display the top 5 most frequent words
            System.out.println("Top 5 most frequent words:");
            for (Map.Entry<String, Integer> entry : top5Words) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }

        } catch (IOException e) {
            System.out.println("Error while reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Specify the file path
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\CounterFile.txt";
        countWordsAndDisplayTop5(filePath);
    }
}

