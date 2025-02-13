package com.day3.JavaStreams;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.*;

public class UserInformationTest {

    @Test
    public void testUserInfoSaver() throws IOException {
        // Prepare input to simulate user input (name, age, language)
        String userInput = "Pranjal\n21\nJava\n";
        System.setIn(new ByteArrayInputStream(userInput.getBytes()));

        // Run the UserInfoSaver program
        UserInformation.main(new String[]{});

        // Read the output file to check if it contains the expected information
        File file = new File("C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\UserInfoTest.txt");
        assertTrue(file.exists(), "File 'C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\UserInfoTest.txt' should exist.");

        // Read the content of the file and verify its correctness
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }

        String expectedContent = "Name: Pranjal\nAge: 21\nFavorite Programming Language: Java\n";
        assertEquals(expectedContent, content.toString(), "The content of the file should match the expected format.");

        // Clean up the created file
        file.delete();
    }
}

