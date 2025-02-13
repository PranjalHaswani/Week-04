package com.day3.JavaStreams;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;

public class FileCopy {
    public static void main(String[] args) {
        String sourceFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\File1.txt";
        String destinationFilePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\DestinationFile.txt";

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            // Check if the source file exists
            File sourceFile = new File(sourceFilePath);
            if (!sourceFile.exists()) {
                System.out.println("Source file does not exist: " + sourceFilePath);
                return;
            }

            // Create the destination file if it does not exist
            File destinationFile = new File(destinationFilePath);
            if (!destinationFile.exists()) {
                destinationFile.createNewFile();
                System.out.println("Destination file created: " + destinationFilePath);
            }

            // Initialize FileInputStream and FileOutputStream
            fis = new FileInputStream(sourceFilePath);
            fos = new FileOutputStream(destinationFilePath);

            int byteData;
            // Read bytes from source and write to destination
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }

            System.out.println("File has been copied successfully.");

        } catch (IOException e) {
            System.out.println("IOException occurred: " + e.getMessage());
        } finally {
            try {
                if (fis != null) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing streams: " + e.getMessage());
            }
        }
    }
}