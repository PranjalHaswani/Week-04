package com.day6.reflection.intemediateLevel;

import java.lang.reflect.Method;
import java.util.Scanner;

class MathOperations {

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
}


public class DynamicMethodInvocations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Get the class object for MathOperations
            Class<?> mathClass = MathOperations.class;

            // Create an instance of MathOperations
            Object mathOperations = mathClass.getDeclaredConstructor().newInstance();

            // Take user input for the operation
            System.out.print("Enter the operation (add, subtract, multiply): ");
            String operation = scanner.nextLine();

            // Take user input for the numbers
            System.out.print("Enter the first number: ");
            int num1 = scanner.nextInt();
            System.out.print("Enter the second number: ");
            int num2 = scanner.nextInt();

            // Get the method to call based on user input
            Method method = mathClass.getMethod(operation, int.class, int.class);

            // Invoke the method dynamically
            Object result = method.invoke(mathOperations, num1, num2);

            // Display the result
            System.out.println("Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
