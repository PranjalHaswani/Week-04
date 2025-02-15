package com.day5.JUnit.AdvancedProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class UserRegistrationTest {

    private final UserRegistration userRegistration = new UserRegistration();

    // Test for valid user registration
    @Test
    public void testValidUserRegistration() {
        // This method should not throw any exceptions if inputs are valid
        assertDoesNotThrow(() -> userRegistration.registerUser("john_doe", "john.doe@example.com", "password123"));
    }

    // Test for invalid username (empty username)
    @Test
    public void testInvalidUsername() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("", "john.doe@example.com", "password123");
        });
        assertEquals("Username cannot be empty", exception.getMessage());
    }

    // Test for invalid email (missing '@')
    @Test
    public void testInvalidEmailWithoutAt() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("john_doe", "john.doeexample.com", "password123");
        });
        assertEquals("Invalid email address", exception.getMessage());
    }


    // Test for invalid password (password too short)
    @Test
    public void testInvalidPasswordTooShort() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("john_doe", "john.doe@example.com", "pass");
        });
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }

    // Test for invalid password (null password)
    @Test
    public void testInvalidPasswordNull() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            userRegistration.registerUser("john_doe", "john.doe@example.com", null);
        });
        assertEquals("Password must be at least 6 characters long", exception.getMessage());
    }
}
