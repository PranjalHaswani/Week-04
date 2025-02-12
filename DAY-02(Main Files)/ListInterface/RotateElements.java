package com.day2.collections.ListInterface;

import java.util.ArrayList;
import java.util.List;

public class RotateElements {

    // Method to rotate the list by given positions
    public static <T> List<T> rotateList(List<T> inputList, int positions) {
        if (inputList == null || inputList.size() <= 1 || positions == 0) {
            return inputList;  // No change needed
        }

        int size = inputList.size();
        // case where positions > size of list
        positions = positions % size;

        // Split the list and re-arrange
        List<T> rotatedList = new ArrayList<>();
        rotatedList.addAll(inputList.subList(positions, size));
        rotatedList.addAll(inputList.subList(0, positions));

        return rotatedList;
    }

    public static void main(String[] args) {
        // Test the function with an example
        List<Integer> inputList = List.of(10, 20, 30, 40, 50);
        List<Integer> result = rotateList(inputList, 2);

        // Print the result
        System.out.println(result);
    }
}
