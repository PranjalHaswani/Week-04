package com.day5.JUnit.AdvancedProblems;
public class UserRegistration {

    // Method to register a user, throws IllegalArgumentException for invalid inputs
    public void registerUser(String username, String email, String password) {
        // Check if the username is valid (non-empty)
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be empty");
        }

        // Check if the email is valid (simple check for '@' and '.' and valid structure)
        if (email == null || !email.contains("@") || !email.contains(".") || email.indexOf('@') > email.lastIndexOf('.')) {
            throw new IllegalArgumentException("Invalid email address");
        }

        // Check if the password is valid (at least 6 characters)
        if (password == null || password.length() < 6) {
            throw new IllegalArgumentException("Password must be at least 6 characters long");
        }

        // Simulate user registration (in a real system, save to database, etc.)
        System.out.println("User " + username + " registered successfully with email " + email);
    }

    public static void main(String[] args) {
        UserRegistration registration = new UserRegistration();

        try {
            // Test valid registration
            registration.registerUser("john_doe", "john.doe@example.com", "password123");
            // Test invalid registration with empty username
            registration.registerUser("", "jane.doe@example.com", "password123");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
