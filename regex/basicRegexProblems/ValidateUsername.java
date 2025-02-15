package com.day5.regex.basicRegexProblems;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUsername {

    // Method to validate the username using regex
    public static boolean isValidUsername(String username) {
        // Regular expression for a valid username
        String regex = "^[a-zA-Z][a-zA-Z0-9_]{4,14}$";

        // Create a Pattern object
        Pattern pattern = Pattern.compile(regex);

        // Create a matcher object
        Matcher matcher = pattern.matcher(username);

        // Check if the username matches the regex
        return matcher.matches();
    }

    public static void main(String[] args) {
        String[] usernames={"user_123", "123user", "us"};
        for(String username: usernames){
            System.out.println(username+ ": " + (isValidUsername(username)?"valid":"invalid"));
        }
    }
}
