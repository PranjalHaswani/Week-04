package com.day3.JavaStreams;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;

public class UserInformation {

    public static void main(String[] args) {
        // BufferedReader for reading input from the user
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        String age = "";
        String language = "";

        try {
            // Ask for the user's name
            System.out.print("Enter your name: ");
            name = reader.readLine();

            // Ask for the user's age
            System.out.print("Enter your age: ");
            age = reader.readLine();

            // Ask for the user's favorite programming language
            System.out.print("Enter your favorite programming language: ");
            language = reader.readLine();

            // Save the user's information into a file
            try (FileWriter writer = new FileWriter("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\UserInfo.txt")) {
                writer.write("Name: " + name + "\n");
                writer.write("Age: " + age + "\n");
                writer.write("Favorite Programming Language: " + language + "\n");
            }

            System.out.println("Your information has been saved to 'C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\UserInfo.txt");

        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}