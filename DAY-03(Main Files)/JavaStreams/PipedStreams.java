package com.day3.JavaStreams;

import java.io.*;

public class PipedStreams {

    // Shared PipedInputStream and PipedOutputStream
    private static PipedInputStream inputStream = new PipedInputStream();
    private static PipedOutputStream outputStream;

    // Writer Thread: Writes data into the PipedOutputStream
    static class WriterThread extends Thread {
        @Override
        public void run() {
            try {
                // Connect the PipedOutputStream to the PipedInputStream
                outputStream = new PipedOutputStream(inputStream);

                // Write data to the PipedOutputStream
                String message = "Hello from the Writer Thread!";
                outputStream.write(message.getBytes());
                outputStream.flush();
                System.out.println("Writer Thread: Data written to the PipedOutputStream.");

            } catch (IOException e) {
                System.out.println("Writer Thread - IOException: " + e.getMessage());
            } finally {
                try {
                    if (outputStream != null) {
                        outputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing output stream: " + e.getMessage());
                }
            }
        }
    }

    // Reader Thread: Reads data from the PipedInputStream
    static class ReaderThread extends Thread {
        @Override
        public void run() {
            try {
                // Read data from the PipedInputStream
                byte[] buffer = new byte[1024];
                int bytesRead = inputStream.read(buffer);
                String message = new String(buffer, 0, bytesRead);

                System.out.println("Reader Thread: Data read from PipedInputStream: " + message);

            } catch (IOException e) {
                System.out.println("Reader Thread - IOException: " + e.getMessage());
            } finally {
                try {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e) {
                    System.out.println("Error closing input stream: " + e.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        // Create and start the writer and reader threads
        WriterThread writerThread = new WriterThread();
        ReaderThread readerThread = new ReaderThread();

        writerThread.start();
        readerThread.start();

        // Wait for both threads to finish
        writerThread.join();
        readerThread.join();

        System.out.println("Main Thread: Communication complete.");
    }
}
