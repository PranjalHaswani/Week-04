package com.day5.regex.ExtractionProblems;
import java.util.regex.*;

public class EmailExtractionFromText {
    public static void main(String[] args) {


        // Example text containing email addresses
        String text = "Contact us at support@example.com and info@company.org";

        // Regular expression for extracting email addresses
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(text);

        // Find and add all matching email addresses to the list
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}

