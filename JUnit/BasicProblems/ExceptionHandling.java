package com.day5.JUnit.BasicProblems;

public class ExceptionHandling {

    // Method to divide two integers and throw ArithmeticException if b is 0
    public int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();

        // Example usage of divide method
        try {
            //Expected: 5
            System.out.println(calculator.divide(10, 2));
            // This will throw exception
            System.out.println(calculator.divide(10, 0));
        } catch (ArithmeticException e) {
            // Expected to print: "Cannot divide by zero"
            System.out.println(e.getMessage());
        }
    }
}
