package com.day3.JavaStreams;

import java.io.*;

public class StudentDetails {

    // Define the file path for storing student data
    private static final String FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\StudentData.txt";

    // Method to write student details into the binary file
    public static void writeStudentDetails(int rollNumber, String name, double gpa) {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream(FILE_PATH))) {
            dos.writeInt(rollNumber);
            dos.writeUTF(name);
            dos.writeDouble(gpa);
            System.out.println("Student details saved successfully.");
        } catch (IOException e) {
            System.out.println("Error while writing student details: " + e.getMessage());
        }
    }

    // Method to read student details from the binary file
    public static void readStudentDetails() {
        try (DataInputStream dis = new DataInputStream(new FileInputStream(FILE_PATH))) {
            int rollNumber = dis.readInt();
            String name = dis.readUTF();
            double gpa = dis.readDouble();
            System.out.println("Student Details:");
            System.out.println("Roll Number: " + rollNumber);
            System.out.println("Name: " + name);
            System.out.println("GPA: " + gpa);
        } catch (IOException e) {
            System.out.println("Error while reading student details: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Write student details
        writeStudentDetails(101, "Alice Johnson", 3.85);

        // Read student details
        readStudentDetails();
    }
}
