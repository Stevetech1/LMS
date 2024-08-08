package GUI;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

// Panel for managing students
public class StudentManagementPanel extends JPanel {
    private List<Student> students = new ArrayList<>(); // List of students
    private StudentTableModel tableModel; // Table model for displaying students
    private List<StudentListObserver> observers = new ArrayList<>(); // List of observers

    public StudentManagementPanel() {
        setLayout(new BorderLayout());

        // Create the table and add it to a scroll pane
        tableModel = new StudentTableModel(students);
        JTable studentTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(studentTable);

        // Create buttons and form for adding students
        JPanel formPanel = new JPanel(new GridLayout(5, 2));
        JTextField nameField = new JTextField();
        JTextField idField = new JTextField();
        JTextField courseField = new JTextField();
        JTextField gradeField = new JTextField();
        JButton addButton = new JButton("Add Student");

        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("ID:"));
        formPanel.add(idField);
        formPanel.add(new JLabel("Course:"));
        formPanel.add(courseField);
        formPanel.add(new JLabel("Grade:"));
        formPanel.add(gradeField);
        formPanel.add(new JLabel()); // Empty cell
        formPanel.add(addButton);

        add(formPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);

        // Add action listener for the "Add Student" button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();
                String course = courseField.getText();
                String grade = gradeField.getText();

                if (!name.isEmpty() && !id.isEmpty() && !course.isEmpty() && !grade.isEmpty()) {
                    Student student = new Student(name, id, course, grade);
                    students.add(student);
                    tableModel.fireTableDataChanged(); // Notify the table model to update
                    notifyObservers(); // Notify observers about the new student
                } else {
                    JOptionPane.showMessageDialog(StudentManagementPanel.this, "All fields must be filled out.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    // Method to add an observer
    public void addObserver(StudentListObserver observer) {
        observers.add(observer);
    }

    // Method to notify all observers
    private void notifyObservers() {
        for (StudentListObserver observer : observers) {
            observer.updateStudentList(students);
        }
    }

    // Public getter method to access the students list
    public List<Student> getStudents() {
        return students;
    }
}

// Observer interface for student list updates
interface StudentListObserver {
    void updateStudentList(List<Student> students);
}
