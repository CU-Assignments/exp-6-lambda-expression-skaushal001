import java.util.*;

class Employee {
    String name;
    int age;
    double salary;

    public Employee(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return name + ", " + age + ", $" + salary;
    }
}

public class EmployeeSorter {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Alice", 25, 50000));
        employees.add(new Employee("Bob", 30, 60000));
        employees.add(new Employee("Charlie", 22, 45000));
        employees.add(new Employee("David", 35, 70000));

        // Sorting by age using lambda
        employees.sort(Comparator.comparing(emp -> emp.age));
        System.out.println("Sorted by Age: " + employees);

        // Sorting by salary using lambda
        employees.sort(Comparator.comparing(emp -> emp.salary));
        System.out.println("Sorted by Salary: " + employees);

        // Sorting by name using lambda
        employees.sort(Comparator.comparing(emp -> emp.name));
        System.out.println("Sorted by Name: " + employees);
    }
}
