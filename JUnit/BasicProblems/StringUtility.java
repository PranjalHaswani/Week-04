package com.day5.JUnit.BasicProblems;

public class StringUtility {

    // Method to reverse a string
    public String reverse(String str) {
        if (str == null) {
            return null;
        }
        return new StringBuilder(str).reverse().toString();
    }

    // Method to check if the string is a palindrome
    public boolean isPalindrome(String str) {
        if (str == null) {
            return false;
        }
        String reversed = reverse(str);
        return str.equals(reversed);
    }

    // Method to convert a string to uppercase
    public String toUpperCase(String str) {
        if (str == null) {
            return null;
        }
        return str.toUpperCase();
    }

    public static void main(String[] args) {
        StringUtility utils = new StringUtility();

        // Test reverse method
        System.out.println("Reverse: " + utils.reverse("hello"));  // olleh

        // Test isPalindrome method

        // true
        System.out.println("Is Palindrome: " + utils.isPalindrome("madam"));
        // false
        System.out.println("Is Palindrome: " + utils.isPalindrome("hello"));

        // Test toUpperCase method

        // HELLO
        System.out.println("To Uppercase: " + utils.toUpperCase("hello"));
    }
}
