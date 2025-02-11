package com.day1.generics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UniversityCourseTest {
            private CourseCatalog catalog;
            private Course<ExamCourse> mathExam;
            private Course<AssignmentCourse> literatureAssignment;
            private Course<ResearchCourse> physicsResearch;

            @BeforeEach
            void setUp() {
                catalog = new CourseCatalog();

                mathExam = new Course<>("Mathematics", "Science", new ExamCourse());
                literatureAssignment = new Course<>("English Literature", "Arts", new AssignmentCourse());
                physicsResearch = new Course<>("Quantum Physics", "Science", new ResearchCourse());

                catalog.addCourse(mathExam);
                catalog.addCourse(literatureAssignment);
                catalog.addCourse(physicsResearch);
            }

            @Test
            void testCourseCreation() {
                assertEquals("Mathematics", mathExam.getCourseName());
                assertEquals("Science", mathExam.getDepartment());
                assertEquals("Exam-Based", mathExam.getCourseType().getName());

                assertEquals("English Literature", literatureAssignment.getCourseName());
                assertEquals("Arts", literatureAssignment.getDepartment());
                assertEquals("Assignment-Based", literatureAssignment.getCourseType().getName());

                assertEquals("Quantum Physics", physicsResearch.getCourseName());
                assertEquals("Science", physicsResearch.getDepartment());
                assertEquals("Research-Based", physicsResearch.getCourseType().getName());
            }
        }
