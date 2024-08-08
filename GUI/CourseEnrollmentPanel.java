package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

// Panel for enrolling students in courses
public class CourseEnrollmentPanel extends JPanel implements StudentListObserver {
    private List<Student> students;
    private JComboBox<Student> studentComboBox;
    private JTextField courseField;

    public CourseEnrollmentPanel() {
        setLayout(new BorderLayout());

        // Create components for course enrollment
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        studentComboBox = new JComboBox<>();
        courseField = new JTextField();
        JButton enrollButton = new JButton("Enroll");

        formPanel.add(new JLabel("Select Student:"));
        formPanel.add(studentComboBox);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(enrollButton);

        add(formPanel, BorderLayout.NORTH);

        // Add action listener for the "Enroll" button
        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                String course = courseField.getText();

                if (selectedStudent != null && !course.isEmpty()) {
                    selectedStudent.setCourse(course);
                    JOptionPane.showMessageDialog(CourseEnrollmentPanel.this, "Student enrolled in course.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(CourseEnrollmentPanel.this, "Please select a student and enter a course.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to update the student combo box
    @Override
    public void updateStudentList(List<Student> students) {
        this.students = students;
        studentComboBox.removeAllItems();
        for (Student student : students) {
            studentComboBox.addItem(student);
        }
    }
}
