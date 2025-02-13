package com.day3.JavaStreams;

import org.junit.jupiter.api.*;


public class PipedStreamsTest {

    @Test
    public void testPipedCommunication() throws InterruptedException {
        // Start the Writer and Reader threads
        PipedStreams.WriterThread writerThread = new PipedStreams.WriterThread();
        PipedStreams.ReaderThread readerThread = new PipedStreams.ReaderThread();

        writerThread.start();
        readerThread.start();

        // Wait for both threads to complete
        writerThread.join();
        readerThread.join();


        System.out.println("Test completed successfully.");
    }
}
