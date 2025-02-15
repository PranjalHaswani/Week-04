package com.day5.JUnit.AdvancedProblems;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class DateFormatterTest {

    private final DateFormatter dateFormatter = new DateFormatter();

    // Test for valid date format
    @Test
    public void testValidDate() {
        // Test a valid date: "2025-02-15"
        try {
            String formattedDate = dateFormatter.formatDate("2025-02-15");
            assertEquals("15-02-2025", formattedDate);  // Expected output should be "15-02-2025"
        } catch (DateTimeParseException e) {
            fail("Parsing failed for valid date: " + e.getMessage());
        }
    }

    @Test
    public void testInvalidDate() {
        // Check that an invalid date throws a DateTimeParseException
        assertThrows(DateTimeParseException.class, () -> {
            LocalDate.parse("2025-02-30");  // February 30th is invalid
        });
    }


    // Test for empty date string
    @Test
    public void testEmptyDate() {
        // Check that an empty string throws a DateTimeParseException
        assertThrows(DateTimeParseException.class, () -> {
            dateFormatter.formatDate("");  // Empty string is invalid
        });
    }

    // Test for incorrect date format (date in the wrong format, e.g. "15-02-2025" instead of "yyyy-MM-dd")
    @Test
    public void testIncorrectFormat() {
        // Check that a date in the wrong format throws a DateTimeParseException
        assertThrows(DateTimeParseException.class, () -> {
            dateFormatter.formatDate("15-02-2025");  // Invalid format (dd-MM-yyyy)
        });
    }
}
