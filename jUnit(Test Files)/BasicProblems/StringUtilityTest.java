package com.day5.JUnit.BasicProblems;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringUtilityTest {

    private final StringUtility utils = new StringUtility();

    @Test
    void testReverse() {
        assertEquals("olleh", utils.reverse("hello"), "Reversed string of 'hello' should be 'olleh'");
        assertEquals("madam", utils.reverse("madam"), "Reversed string of 'madam' should be 'madam'");
        assertEquals("12321", utils.reverse("12321"), "Reversed string of '12321' should be '12321'");
        assertNull(utils.reverse(null), "Reversed string of null should be null");
    }

    @Test
    void testIsPalindrome() {
        assertTrue(utils.isPalindrome("madam"), "'madam' should be a palindrome");
        assertFalse(utils.isPalindrome("hello"), "'hello' should not be a palindrome");
        assertTrue(utils.isPalindrome("12321"), "'12321' should be a palindrome");
        assertFalse(utils.isPalindrome("abc"), "'abc' should not be a palindrome");
    }

    @Test
    void testToUpperCase() {
        assertEquals("HELLO", utils.toUpperCase("hello"), "'hello' should be converted to 'HELLO'");
        assertEquals("WORLD", utils.toUpperCase("world"), "'world' should be converted to 'WORLD'");
        assertNull(utils.toUpperCase(null), "Uppercase of null should be null");
    }
}

