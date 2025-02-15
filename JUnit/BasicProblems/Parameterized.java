package com.day5.JUnit.BasicProblems;

public class Parameterized {

    // Method to check if a number is even
    public boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static void main(String[] args) {
        Parameterized numberUtils = new Parameterized();

        // Test examples
        System.out.println("Is 2 even? " + numberUtils.isEven(2));
        System.out.println("Is 4 even? " + numberUtils.isEven(4));
        System.out.println("Is 7 even? " + numberUtils.isEven(7));
        System.out.println("Is 9 even? " + numberUtils.isEven(9));
    }
}
