package com.day3.JavaStreams;
import org.junit.jupiter.api.*;
import java.io.*;
import static org.junit.jupiter.api.Assertions.*;

public class StudentDetailsTest {

    private static final String TEST_FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\StudentDetailsTest.txt";

    @BeforeEach
    public void setUp() throws IOException {
        // Clean up the test file before each test
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }

    @Test
    public void testWriteAndReadStudentDetails() {
        // Write student details
        StudentDetails.writeStudentDetails(101, "Alice Johnson", 3.85);

        // Now read the student details from the file and verify
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);  // Redirect System.out to capture output

        StudentDetails.readStudentDetails();  // This should print the student details

        String output = outputStream.toString();
        assertTrue(output.contains("Roll Number: 101"), "Roll number should be 101.");
        assertTrue(output.contains("Name: Alice Johnson"), "Name should be 'Alice Johnson'.");
        assertTrue(output.contains("GPA: 3.85"), "GPA should be 3.85.");
    }

    @AfterEach
    public void tearDown() {
        // Clean up the test file after the test
        File testFile = new File(TEST_FILE_PATH);
        if (testFile.exists()) {
            testFile.delete();
        }
    }
}
