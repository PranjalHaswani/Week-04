package com.day4.exceptionHandling;

import java.util.Scanner;

public class MultipleCatchBlocks {

    // Method to retrieve the value from the array at the given index
    public static void retrieveValue(int[] arr, int index) {
        try {
            // Check if the array is null
            if (arr == null) {
                throw new NullPointerException();
            }

            // Retrieve the value at the specified index
            int value = arr[index];
            System.out.println("Value at index " + index + ": " + value);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid index!");
        } catch (NullPointerException e) {
            System.out.println("Array is not initialized!");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept the array length and values from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] array = new int[size];

        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < size; i++) {
            array[i] = scanner.nextInt();
        }

        // Accept the index to retrieve the value
        System.out.print("Enter the index to retrieve the value: ");
        int index = scanner.nextInt();

        // Call the retrieveValue method
        retrieveValue(array, index);

        scanner.close();
    }
}
