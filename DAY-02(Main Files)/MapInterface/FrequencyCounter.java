package com.day2.collections.MapInterface;

import java.io.*;
import java.util.*;

public class FrequencyCounter {

    // Method to count word frequencies from a text file
    public static Map<String, Integer> countWordFrequencies(String filePath) throws IOException {
        Map<String, Integer> wordCountMap = new HashMap<>();

        // Read the file line by line
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Normalize the line to lowercase and remove punctuation using regex
                line = line.toLowerCase().replaceAll("[^a-zA-Z\\s]", "");

                // Split the line into words
                String[] words = line.split("\\s+");

                // Count the frequency of each word
                for (String word : words) {
                    if (!word.isEmpty()) {
                        wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
                    }
                }
            }
        }

        return wordCountMap;
    }

    // Main method to run the program
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\java\\com\\day2\\collections\\MapInterface\\File1";
        Map<String, Integer> wordFrequencies = countWordFrequencies(filePath);
        System.out.println(wordFrequencies);
    }
}
