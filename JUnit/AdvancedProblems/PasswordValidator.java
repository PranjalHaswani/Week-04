package com.day5.JUnit.AdvancedProblems;

public class PasswordValidator {

    // Method to validate password
    public boolean isValidPassword(String password) {
        if (password == null) {
            return false;
        }

        // Check if password length is at least 8 characters
        if (password.length() < 8) {
            return false;
        }

        // Check for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            return false;
        }

        // Check for at least one digit
        if (!password.matches(".*\\d.*")) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        // Create a PasswordValidator instance
        PasswordValidator validator = new PasswordValidator();

        // Test the validation method
        String password1 = "Valid123";
        System.out.println(password1 + " is valid: " + validator.isValidPassword(password1));

        String password2 = "invalid";
        System.out.println(password2 + " is valid: " + validator.isValidPassword(password2));

        String password3 = "Password1";
        System.out.println(password3 + " is valid: " + validator.isValidPassword(password3));
    }
}
