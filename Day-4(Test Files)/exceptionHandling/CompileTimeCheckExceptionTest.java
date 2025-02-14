package com.day4.exceptionHandling;
import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

class CheckedExceptionProgramTest {

    @Test
    void testFileNotFoundException() {
        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("nonexistent.txt"));
        });

        assertTrue(exception.getMessage().contains("nonexistent.txt"));
    }

    @Test
    void testIOExceptionHandling() {
        assertDoesNotThrow(() -> {
            File tempFile = File.createTempFile("testfile", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("Hello, World!");
            writer.close();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(tempFile));
            assertNotNull(bufferedReader.readLine());
            bufferedReader.close();
        });
    }
}