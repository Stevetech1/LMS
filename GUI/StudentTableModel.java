package GUI;

import java.util.List;

import javax.swing.table.AbstractTableModel;

// Table model for managing student data in a JTable
public class StudentTableModel extends AbstractTableModel {
    private List<Student> students; // List of students
    private String[] columnNames = {"Name", "ID", "Course", "Grade"}; // Column names

    // Constructor to initialize the table model with a list of students
    public StudentTableModel(List<Student> students) {
        this.students = students;
    }

    @Override
    public int getRowCount() {
        return students.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex) {
            case 0: return student.getName();
            case 1: return student.getId();
            case 2: return student.getCourse();
            case 3: return student.getGrade();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
