package com.day3.JavaStreams;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeManagerTest {

    private static final String FILE_PATH = "C:\\Users\\sunny\\OneDrive\\Desktop\\Capgemini\\WEEK-04\\src\\test\\resources\\FileForEmployeeTest.txt";

    @BeforeEach
    void setup() {
        // Clean up the file before each test to ensure we're working with a fresh file
        File file = new File(FILE_PATH);
        if (file.exists()) {
        }
    }

    @Test
    void testSerializeEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        // Serialize employees to file
        EmployeeManager.serializeEmployees(employees);

        // Check if the file exists after serialization
        File file = new File(FILE_PATH);
        assertTrue(file.exists(), "The file should be created after serialization");
    }

    @Test
    void testDeserializeEmployees() {
        // Prepare test data
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(101, "Alice", "HR", 50000));
        employees.add(new Employee(102, "Bob", "IT", 60000));
        employees.add(new Employee(103, "Charlie", "Finance", 70000));

        // Serialize employees to file
        EmployeeManager.serializeEmployees(employees);

        // Deserialize employees from the file
        List<Employee> deserializedEmployees = EmployeeManager.deserializeEmployees();

        // Verify the deserialized employees list is not null and contains the correct data
        assertNotNull(deserializedEmployees, "Deserialized employee list should not be null");
        assertEquals(3, deserializedEmployees.size(), "There should be 3 employees deserialized");

        // Verify each employee's data
        assertEquals(101, deserializedEmployees.get(0).getId());
        assertEquals("Alice", deserializedEmployees.get(0).getName());
        assertEquals("HR", deserializedEmployees.get(0).getDepartment());
        assertEquals(50000, deserializedEmployees.get(0).getSalary());

        assertEquals(102, deserializedEmployees.get(1).getId());
        assertEquals("Bob", deserializedEmployees.get(1).getName());
        assertEquals("IT", deserializedEmployees.get(1).getDepartment());
        assertEquals(60000, deserializedEmployees.get(1).getSalary());

        assertEquals(103, deserializedEmployees.get(2).getId());
        assertEquals("Charlie", deserializedEmployees.get(2).getName());
        assertEquals("Finance", deserializedEmployees.get(2).getDepartment());
        assertEquals(70000, deserializedEmployees.get(2).getSalary());
    }

    @AfterEach
    void tearDown() {
        // Clean up the file after each test
        File file = new File(FILE_PATH);
        if (file.exists()) {
            file.delete();
        }
    }
}
