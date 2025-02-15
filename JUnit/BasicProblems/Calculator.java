package com.day5.JUnit.BasicProblems;

public class Calculator {

    // Method to add two numbers
    public int add(int a, int b) {
        return a + b;
    }

    // Method to subtract two numbers
    public int subtract(int a, int b) {
        return a - b;
    }

    // Method to multiply two numbers
    public int multiply(int a, int b) {
        return a * b;
    }

    // Method to divide two numbers
    public double divide(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }
        return (double) a / b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Addition: " + calculator.add(5, 3));           // 8
        System.out.println("Subtraction: " + calculator.subtract(5, 3));   // 2
        System.out.println("Multiplication: " + calculator.multiply(5, 3)); // 15
        try {
            System.out.println("Division: " + calculator.divide(5, 0));    // Should throw exception
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}

