package com.university.management;

import java.util.HashMap;
import java.util.Map;

public class Student {
    private String name;
    private String id;
    private Map<Course, Double> enrolledCourses; // Course and their respective grades

    // Constructor
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
        this.enrolledCourses = new HashMap<>();
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map<Course, Double> getEnrolledCourses() {
        return enrolledCourses;
    }

    // Method to enroll in a course
    public void enrollInCourse(Course course) {
        if (course.getEnrolledStudents() < course.getMaxCapacity()) {
            enrolledCourses.put(course, null);
            course.incrementEnrollment();
        } else {
            System.out.println("Cannot enroll, course is full.");
        }
    }

    // Method to assign a grade for a course
    public void assignGrade(Course course, double grade) {
        if (enrolledCourses.containsKey(course)) {
            enrolledCourses.put(course, grade);
        } else {
            System.out.println("Student not enrolled in the course.");
        }
    }
}