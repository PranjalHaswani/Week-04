package com.day5.regex.ReplaceAndModifyStrings;

public class MultipleSpaceWithSingle {
    public static void main(String[] args) {
        // Example input
        String input = "This             is   an    example    with    multiple  spaces.";

        // Use regex to replace multiple spaces with a single space
        String output = input.replaceAll("\\s+", " ");

        // Output the result
        System.out.println(output);
    }
}
