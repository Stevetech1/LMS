import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    // Constructor to initialize employee attributes
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    // Getter methods to access the private attributes
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getDepartment() { return department; }
    public double getSalary() { return salary; }
}

public class EmployeeProcessor {

    public static void main(String[] args) {
        // Step 1: Create and store the dataset in a collection
        List<Employee> employees = Arrays.asList(
            new Employee("Steve Ojata", 40, "Health Information Management", 50000),
            new Employee("Adejoh Sunday", 35, "Admin Department", 70000),
            new Employee("Benaiah Stephen", 28, "Engineering Department", 45000),
            new Employee("Bernice Ojonuba", 30, "Mechine Department", 120000)
        );

        // Step 2: Define a Function interface to concatenate name and department
        Function<Employee, String> nameAndDepartment = emp -> emp.getName() + " - " + emp.getDepartment();

        // Step 3: Use stream to generate a collection of concatenated strings
        List<String> nameDeptList = employees.stream()
            .map(nameAndDepartment)  // Apply the function to each employee
            .collect(Collectors.toList());  // Collect the results into a list

        // Print the concatenated strings
        System.out.println("Name and Department List:");
        nameDeptList.forEach(System.out::println);

        // Step 4: Calculate the average salary using streams
        double averageSalary = employees.stream()
            .mapToDouble(Employee::getSalary)  // Extract salary for each employee
            .average()  // Calculate the average
            .orElse(0.0);  // Provide a default value if the list is empty

        System.out.println("Average Salary: " + averageSalary);

        // Step 5: Filter employees whose age is above 30 and process the dataset
        List<String> filteredNameDeptList = employees.stream()
            .filter(emp -> emp.getAge() > 30)  // Filter employees by age
            .map(nameAndDepartment)  // Apply the name and department concatenation
            .collect(Collectors.toList());  // Collect the filtered results into a list

        // Print the filtered list
        System.out.println("Filtered Name and Department List (Age > 30):");
        filteredNameDeptList.forEach(System.out::println);
    }
}
