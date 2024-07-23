package com.university.management;

import java.util.Scanner;

public class AdministratorInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Administrator Menu:");
            System.out.println("1. Add new course");
            System.out.println("2. Enroll student in course");
            System.out.println("3. Assign grade to student");
            System.out.println("4. Calculate overall grade for student");
            System.out.println("5. Exit");
            System.out.print("Select an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter course code: ");
                    String courseCode = scanner.nextLine();
                    System.out.print("Enter course name: ");
                    String courseName = scanner.nextLine();
                    System.out.print("Enter maximum capacity: ");
                    int maxCapacity = scanner.nextInt();
                    scanner.nextLine(); // consume newline
                    CourseManagement.addCourse(courseCode, courseName, maxCapacity);
                    break;

                case 2:
                    System.out.print("Enter student name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    String studentId = scanner.nextLine();
                    Student student = new Student(studentName, studentId);
                    CourseManagement.addStudent(student);

                    System.out.print("Enter course code to enroll: ");
                    String enrollCourseCode = scanner.nextLine();
                    Course course = null;
                    for (Course c : CourseManagement.getCourses()) {
                        if (c.getCourseCode().equals(enrollCourseCode)) {
                            course = c;
                            break;
                        }
                    }
                    if (course != null) {
                        CourseManagement.enrollStudent(student, course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter student ID: ");
                    String gradeStudentId = scanner.nextLine();
                    Student gradeStudent = null;
                    for (Student s : CourseManagement.getStudents()) {
                        if (s.getId().equals(gradeStudentId)) {
                            gradeStudent = s;
                            break;
                        }
                    }

                    if (gradeStudent != null) {
                        System.out.print("Enter course code: ");
                        String gradeCourseCode = scanner.nextLine();
                        Course gradeCourse = null;
                        for (Course c : CourseManagement.getCourses()) {
                            if (c.getCourseCode().equals(gradeCourseCode)) {
                                gradeCourse = c;
                                break;
                            }
                        }

                        if (gradeCourse != null) {
                            System.out.print("Enter grade: ");
                            double grade = scanner.nextDouble();
                            scanner.nextLine(); // consume newline
                            CourseManagement.assignGrade(gradeStudent, gradeCourse, grade);
                        } else {
                            System.out.println("Course not found.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter student ID: ");
                    String calcStudentId = scanner.nextLine();
                    Student calcStudent = null;
                    for (Student s : CourseManagement.getStudents()) {
                        if (s.getId().equals(calcStudentId)) {
                            calcStudent = s;
                            break;
                        }
                    }

                    if (calcStudent != null) {
                        double overallGrade = CourseManagement.calculateOverallGrade(calcStudent);
                        System.out.println("Overall Grade: " + overallGrade);
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}