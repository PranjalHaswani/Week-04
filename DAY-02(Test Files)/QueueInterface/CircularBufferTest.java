package com.day2.collections.QueueInterface;

import static org.junit.jupiter.api.Assertions.*;



import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CircularBufferTest {
    @Test
    void testInsertionAndRetrieval() {
        CircularBufferSimulation<Integer> buffer = new CircularBufferSimulation<>(3);
        buffer.insert(1);
        buffer.insert(2);
        buffer.insert(3);
        assertArrayEquals(new Integer[]{1, 2, 3}, buffer.getBufferContents());

        buffer.insert(4);
        assertArrayEquals(new Integer[]{2, 3, 4}, buffer.getBufferContents());
    }

    @Test
    void testOverwrite() {
        CircularBufferSimulation<String> buffer = new CircularBufferSimulation<>(2);
        buffer.insert("A");
        buffer.insert("B");
        buffer.insert("C");
        assertArrayEquals(new String[]{"B", "C"}, buffer.getBufferContents());
    }

    @Test
    void testEmptyBuffer() {
        CircularBufferSimulation<Double> buffer = new CircularBufferSimulation<>(3);
        assertArrayEquals(new Double[]{}, buffer.getBufferContents());
    }
}