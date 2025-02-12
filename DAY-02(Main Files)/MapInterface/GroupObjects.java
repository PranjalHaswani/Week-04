package com.day2.collections.MapInterface;
import java.util.*;

public class GroupObjects {

    // Enum for Departments
    public enum Department {
        HR,
        IT,
        FINANCE,
        MARKETING
    }

    // Employee class to represent an employee
    public static class Employee {
        private String name;
        private Department department;

        // Constructor
        public Employee(String name, Department department) {
            this.name = name;
            this.department = department;
        }

        // Getter methods
        public String getName() {
            return name;
        }

        public Department getDepartment() {
            return department;
        }

        @Override
        public String toString() {
            return name;
        }

        // Override equals and hashCode to compare Employee objects by value
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return Objects.equals(name, employee.name) && department == employee.department;
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, department);
        }
    }

    // Method to group employees by their department
    public static Map<Department, List<Employee>> groupByDepartment(List<Employee> employees) {
        Map<Department, List<Employee>> departmentMap = new HashMap<>();

        for (Employee employee : employees) {
            // Add employee to the corresponding department's list
            departmentMap
                    .computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                    .add(employee);
        }

        return departmentMap;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a list of employees
        List<Employee> employees = Arrays.asList(
                new Employee("Alice", Department.HR),
                new Employee("Bob", Department.IT),
                new Employee("Carol", Department.HR),
                new Employee("David", Department.FINANCE)
        );

        // Group the employees by their department
        Map<Department, List<Employee>> groupedEmployees = groupByDepartment(employees);

        // Print the grouped employees
        for (Map.Entry<Department, List<Employee>> entry : groupedEmployees.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
