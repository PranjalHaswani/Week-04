package com.day5.JUnit.AdvancedProblems;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PasswordValidatorTest {

    private final PasswordValidator validator = new PasswordValidator();

    // Test for valid passwords
    @Test
    public void testValidPasswords() {
        assertTrue(validator.isValidPassword("Valid123"), "Password 'Valid123' should be valid");
        assertTrue(validator.isValidPassword("Password1"), "Password 'Password1' should be valid");
    }

    // Test for null password
    @Test
    public void testNullPassword() {
        assertFalse(validator.isValidPassword(null), "Null password should be invalid");
    }
}
