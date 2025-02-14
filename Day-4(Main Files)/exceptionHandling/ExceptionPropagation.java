package com.day4.exceptionHandling;

public class ExceptionPropagation {

    // method1() throws an ArithmeticException
    public static void method1() {
        // This will throw an ArithmeticException because of division by zero
        int result = 10 / 0;
    }

    // method2() calls method1(), so it will propagate the exception from method1
    public static void method2() {
        method1();
    }

    public static void main(String[] args) {
        try {
            // Calling method2() will propagate the exception to main
            method2();
        } catch (ArithmeticException e) {
            // Catching the exception in main and handling it
            System.out.println("Handled exception in main");
        }
    }
}
