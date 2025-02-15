package com.day5.JUnit.AdvancedProblems;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    // Method to format date from yyyy-MM-dd to dd-MM-yyyy
    public String formatDate(String inputDate) throws DateTimeParseException {
        // Define the input and output date formats
        DateTimeFormatter inputFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter outputFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Try to parse the input date
        try {
            // Parse the input string into a LocalDate object
            LocalDate date = LocalDate.parse(inputDate, inputFormat);

            // Format the LocalDate object to the desired output format
            return date.format(outputFormat);
        } catch (DateTimeParseException e) {
            // Rethrow the exception if date is invalid
            throw new DateTimeParseException("Invalid date format or date", inputDate, e.getErrorIndex());
        }
    }

    public static void main(String[] args) {
        DateFormatter dateFormatter = new DateFormatter();

        try {
            // Test valid date
            System.out.println("Formatted date: " + dateFormatter.formatDate("2025-02-15"));

            // Test invalid date
            System.out.println("Formatted date: " + dateFormatter.formatDate("2025-02-30"));
        } catch (DateTimeParseException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
