package GUI;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

// Main class for the Student Management System
public class StudentManagementSystem {
    public static void main(String[] args) {
        // Schedule a job for the event-dispatching thread
        SwingUtilities.invokeLater(() -> {
            // Create and set up the main application frame
            JFrame frame = new JFrame("Student Management System");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600); // Set the size of the frame

            // Create a tabbed pane
            JTabbedPane tabbedPane = new JTabbedPane();

            // Create panels
            StudentManagementPanel studentManagementPanel = new StudentManagementPanel();
            CourseEnrollmentPanel courseEnrollmentPanel = new CourseEnrollmentPanel();
            GradeManagementPanel gradeManagementPanel = new GradeManagementPanel();

            // Add tabs for student management, course enrollment, and grade management
            tabbedPane.addTab("Student Management", studentManagementPanel);
            tabbedPane.addTab("Course Enrollment", courseEnrollmentPanel);
            tabbedPane.addTab("Grade Management", gradeManagementPanel);

            // Add the tabbed pane to the frame
            frame.add(tabbedPane);

            // Add observers to student management panel
            studentManagementPanel.addObserver(courseEnrollmentPanel);
            studentManagementPanel.addObserver(gradeManagementPanel);

            // Display the frame
            frame.setVisible(true);
        });
    }
}
