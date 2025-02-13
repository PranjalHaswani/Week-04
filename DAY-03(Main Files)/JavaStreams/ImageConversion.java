package com.day3.JavaStreams;

import java.io.*;

public class ImageConversion {

    // Method to convert an image file to a byte array
    public static byte[] imageToByteArray(String imagePath) throws IOException {
        FileInputStream fileInputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            // Reading the image into a byte array
            fileInputStream = new FileInputStream(imagePath);
            byteArrayOutputStream = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                byteArrayOutputStream.write(buffer, 0, bytesRead);
            }
            return byteArrayOutputStream.toByteArray();

        } finally {
            // Close the streams
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            if (byteArrayOutputStream != null) {
                byteArrayOutputStream.close();
            }
        }
    }

    // Method to write a byte array back into an image file
    public static void byteArrayToImage(byte[] byteArray, String outputImagePath) throws IOException {
        ByteArrayInputStream byteArrayInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(byteArray);
            fileOutputStream = new FileOutputStream(outputImagePath);

            int bytesRead;
            byte[] buffer = new byte[1024];
            while ((bytesRead = byteArrayInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, bytesRead);
            }
        } finally {
            // Close the streams
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
        }
    }

    public static void main(String[] args) {
        String inputImagePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\CollegeImage.jpg";
        String outputImagePath = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\main\\resources\\CopyImage.jpg";

        try {
            // Convert the image to byte array
            byte[] imageBytes = imageToByteArray(inputImagePath);

            // Convert the byte array back to an image file
            byteArrayToImage(imageBytes, outputImagePath);

            System.out.println("Image conversion successful. Check the output image file.");
        } catch (IOException e) {
            System.err.println("IOException occurred: " + e.getMessage());
        }
    }
}
