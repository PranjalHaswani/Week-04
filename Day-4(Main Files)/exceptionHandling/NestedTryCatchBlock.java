package com.day4.exceptionHandling;

import java.util.Scanner;

public class NestedTryCatchBlock {

    // Method to divide an element at a specific index of the array by a divisor
    public String divideElement(int[] arr, int index, int divisor) {
        try {
            try {
                // Try to access the element at the given index
                int element = arr[index];

                try {
                    // Try to divide the element by the divisor
                    int result = element / divisor;
                    return "Division result: " + result;
                } catch (ArithmeticException e) {
                    // Handle division by zero
                    return "Cannot divide by zero!";
                }

            } catch (ArrayIndexOutOfBoundsException e) {
                // Handle invalid index
                return "Invalid array index!";
            }
        } catch (Exception e) {
            // Generic exception handler for other unexpected issues
            return "An error occurred: " + e.getMessage();
        }
    }

    // Main method to execute the program (can be used for testing or actual input)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking input for array size and array elements
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }

        // Taking input for index and divisor
        System.out.print("Enter the index to access: ");
        int index = scanner.nextInt();
        System.out.print("Enter the divisor: ");
        int divisor = scanner.nextInt();

        // Call divideElement method
        NestedTryCatchBlock obj = new NestedTryCatchBlock();
        System.out.println(obj.divideElement(arr, index, divisor));

        scanner.close();
    }
}
