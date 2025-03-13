import java.util.*;
import java.util.stream.Collectors;

class Student {
    String name;
    double marks;

    public Student(String name, double marks) {
        this.name = name;
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    @Override
    public String toString() {
        return name + " - " + marks + "%";
    }
}

public class StudentFilter {
    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
            new Student("Alice", 85.5),
            new Student("Bob", 72.0),
            new Student("Charlie", 78.8),
            new Student("David", 90.2),
            new Student("Eve", 65.4)
        );

        List<String> filteredStudents = students.stream()
            .filter(student -> student.getMarks() > 75)  
            .sorted(Comparator.comparing(Student::getMarks).reversed())  
            .map(Student::getName) 
            .collect(Collectors.toList());  
        System.out.println("Students scoring above 75% (sorted by marks): " + filteredStudents);
    }
}
