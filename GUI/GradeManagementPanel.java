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

// Panel for managing student grades
public class GradeManagementPanel extends JPanel implements StudentListObserver {
    private List<Student> students;
    private JComboBox<Student> studentComboBox;
    private JTextField gradeField;

    public GradeManagementPanel() {
        setLayout(new BorderLayout());

        // Create components for grade management
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        studentComboBox = new JComboBox<>();
        gradeField = new JTextField();
        JButton assignGradeButton = new JButton("Assign Grade");

        formPanel.add(new JLabel("Select Student:"));
        formPanel.add(studentComboBox);
        formPanel.add(new JLabel("Grade:"));
        formPanel.add(gradeField);
        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(assignGradeButton);

        add(formPanel, BorderLayout.NORTH);

        // Add action listener for the "Assign Grade" button
        assignGradeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Student selectedStudent = (Student) studentComboBox.getSelectedItem();
                String grade = gradeField.getText();

                if (selectedStudent != null && !grade.isEmpty()) {
                    selectedStudent.setGrade(grade);
                    JOptionPane.showMessageDialog(GradeManagementPanel.this, "Grade assigned to student.", "Success", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(GradeManagementPanel.this, "Please select a student and enter a grade.", "Error", JOptionPane.ERROR_MESSAGE);
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
