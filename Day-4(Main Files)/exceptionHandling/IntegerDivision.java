package com.day4.exceptionHandling;
import java.util.Scanner;

public class IntegerDivision {

    public static String divide(int numerator, int denominator) {
        try {
            // Perform division and return the result
            int result = numerator / denominator;
            return "Result: " + result;
        } catch (ArithmeticException e) {
            // Handle division by zero
            return "Error: Cannot divide by zero.";
        } finally {
            // Always print "Operation completed."
            System.out.println("Operation completed.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take two integers from the user
        System.out.print("Enter the numerator: ");
        int numerator = scanner.nextInt();

        System.out.print("Enter the denominator: ");
        int denominator = scanner.nextInt();

        // Call divide method and print the result
        String result = divide(numerator, denominator);
        System.out.println(result);
    }
}

