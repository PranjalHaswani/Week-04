package com.day2.collections.MapInterface;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
import java.util.*;

public class GroupObjectsTest {

    @Test
    public void testMainMethod() throws IOException {
        // Create a list of employees for the test
        List<GroupObjects.Employee> employees = Arrays.asList(
                new GroupObjects.Employee("Alice", GroupObjects.Department.HR),
                new GroupObjects.Employee("Bob", GroupObjects.Department.IT),
                new GroupObjects.Employee("Carol", GroupObjects.Department.HR),
                new GroupObjects.Employee("David", GroupObjects.Department.FINANCE)
        );

        // Call the groupByDepartment method to group employees by their department
        Map<GroupObjects.Department, List<GroupObjects.Employee>> groupedEmployees = GroupObjects.groupByDepartment(employees);

        // Capture the console output by redirecting System.out
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // Call the main method (it prints the output to the console)
        GroupObjects.main(new String[]{});

        // Get the captured output
        String output = outContent.toString();

        // Verify the output matches the expected output
        assertTrue(output.contains("HR: [Alice, Carol]"));
        assertTrue(output.contains("IT: [Bob]"));
        assertTrue(output.contains("FINANCE: [David]"));
    }
}
