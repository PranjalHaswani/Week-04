package com.day6.annotation.exerciseProblems;

import java.util.ArrayList;

public class UncheckedWarningsExample {

    @SuppressWarnings("unchecked")  // Suppressing unchecked warnings
    public static void main(String[] args) {
        // Create an ArrayList without generics (this will cause unchecked warnings)
        ArrayList list = new ArrayList();  // Raw type usage

        // Add elements of different types
        list.add("Hello");
        list.add(10);
        list.add(3.14);

        // Access elements and cast them (unchecked warning)
        String message = (String) list.get(0);
        Integer number = (Integer) list.get(1);
        Double pi = (Double) list.get(2);

        // Print values
        System.out.println("String value: " + message);
        System.out.println("Integer value: " + number);
        System.out.println("Double value: " + pi);
    }
}
