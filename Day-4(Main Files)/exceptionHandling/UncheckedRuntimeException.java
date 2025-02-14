package com.day4.exceptionHandling;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UncheckedRuntimeException {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            try {
                System.out.println("Enter the numerator: ");
                int numerator = scanner.nextInt();
                System.out.println("Enter the denominator: ");
                int denominator = scanner.nextInt();

                //Perform the division and see result
                int result = numerator / denominator;
                System.out.println("Result: " + result);
            }
            catch (ArithmeticException e) {
                System.out.println("Error: Divisible by zero is not allowed. "+e.getMessage());
            }
            catch (InputMismatchException e){
                System.out.println("Error: Please enter valid numbers. "+e.getMessage());
            }
        }
    }

