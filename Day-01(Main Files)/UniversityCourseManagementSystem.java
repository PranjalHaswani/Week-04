package com.day1.generics;

import java.util.ArrayList;
import java.util.List;

// Abstract class representing different course types
abstract class CourseType {
    private String name;

    public CourseType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// Concrete course types
class ExamCourse extends CourseType {
    public ExamCourse() {
        super("Exam-Based");
    }
}

class AssignmentCourse extends CourseType {
    public AssignmentCourse() {
        super("Assignment-Based");
    }
}

class ResearchCourse extends CourseType {
    public ResearchCourse() {
        super("Research-Based");
    }
}

// Generic class to represent a Course
class Course<T extends CourseType> {
    private String courseName;
    private String department;
    private T courseType;

    public Course(String courseName, String department, T courseType) {
        this.courseName = courseName;
        this.department = department;
        this.courseType = courseType;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public T getCourseType() {
        return courseType;
    }

    @Override
    public String toString() {
        return courseName + " (" + department + ") - " + courseType.getName();
    }
}

// Course Catalog to manage different courses
class CourseCatalog {
    private List<Course<? extends CourseType>> courses = new ArrayList<>();

    public void addCourse(Course<? extends CourseType> course) {
        courses.add(course);
    }

    public void showCourses() {
        for (Course<? extends CourseType> course : courses) {
            System.out.println(course);
        }
    }
}

// Main class
public class UniversityCourseManagementSystem {
    public static void main(String[] args) {
        CourseCatalog catalog = new CourseCatalog();

        // Creating different courses
        Course<ExamCourse> mathExam = new Course<>("Mathematics", "Science", new ExamCourse());
        Course<AssignmentCourse> literatureAssignment = new Course<>("English Literature", "Arts", new AssignmentCourse());
        Course<ResearchCourse> physicsResearch = new Course<>("Quantum Physics", "Science", new ResearchCourse());

        // Adding courses to the catalog
        catalog.addCourse(mathExam);
        catalog.addCourse(literatureAssignment);
        catalog.addCourse(physicsResearch);

        // Displaying all courses
        System.out.println("Available Courses:");
        catalog.showCourses();
    }
}