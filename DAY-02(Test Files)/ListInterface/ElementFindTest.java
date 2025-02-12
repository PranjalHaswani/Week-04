package com.day2.collections.ListInterface;

import org.junit.jupiter.api.Test;
import java.util.LinkedList;
import static org.junit.jupiter.api.Assertions.*;

public class ElementFindTest {

    @Test
    public void testFindNthFromEnd() {
        // Test case: find the 2nd element from the end
        LinkedList<String> list = new LinkedList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        String result = ElementFind.findNthFromEnd(list, 2);
        // Expected output: D
        assertEquals("D", result);
    }
}
