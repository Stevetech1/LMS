package GUI;

// Class representing a student
public class Student {
    private String name;
    private String id;
    private String course;
    private String grade;

    // Constructor to initialize student details
    public Student(String name, String id, String course, String grade) {
        this.name = name;
        this.id = id;
        this.course = course;
        this.grade = grade;
    }

    // Getters and setters for student attributes
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

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return name; // For display in JComboBox
    }
}
