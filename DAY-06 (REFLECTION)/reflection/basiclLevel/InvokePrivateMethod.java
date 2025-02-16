package com.day6.reflection.basiclLevel;

import java.lang.reflect.Method;

class Calculator {

    // Private method that multiplies two numbers
    private int multiply(int a, int b) {
        return a * b;
    }
}

public class InvokePrivateMethod {

    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Use Reflection to get the private method 'multiply'
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private method with parameters 5 and 4
            Object result = multiplyMethod.invoke(calculator, 5, 4);

            // Display the result
            System.out.println("Result of multiply(5, 4): " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
