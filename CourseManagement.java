package com.university.management;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CourseManagement {
    private static List<Course> courses = new ArrayList<>();
    private static List<Student> students = new ArrayList<>();

    // Method to add a new course
    public static void addCourse(String courseCode, String name, int maxCapacity) {
        Course newCourse = new Course(courseCode, name, maxCapacity);
        courses.add(newCourse);
    }

    // Method to enroll a student in a course
    public static void enrollStudent(Student student, Course course) {
        student.enrollInCourse(course);
    }

    // Method to assign a grade to a student for a course
    public static void assignGrade(Student student, Course course, double grade) {
        student.assignGrade(course, grade);
    }

    // Method to calculate the overall grade for a student
    public static double calculateOverallGrade(Student student) {
        double totalGrades = 0;
        int totalCourses = 0;

        for (Map.Entry<Course, Double> entry : student.getEnrolledCourses().entrySet()) {
            Double grade = entry.getValue();
            if (grade != null) {
                totalGrades += grade;
                totalCourses++;
            }
        }

        if (totalCourses == 0) {
            return 0;
        }
        return totalGrades / totalCourses;
    }

    // Method to add a student to the system
    public static void addStudent(Student student) {
        students.add(student);
    }

    // Getter methods for courses and students
    public static List<Course> getCourses() {
        return courses;
    }

    public static List<Student> getStudents() {
        return students;
    }
}
