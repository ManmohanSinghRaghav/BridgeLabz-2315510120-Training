import java.util.*;

// Abstract class Employee
abstract class Employee {
    private String employeeId;
    private String name;
    private double baseSalary;
    
    public Employee(String employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }
    
    // Getters and Setters
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { 
        if (baseSalary > 0) this.baseSalary = baseSalary; 
    }
    
    // Abstract method
    public abstract double calculateSalary();
    
    // Concrete method
    public void displayDetails() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + baseSalary);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Interface Department
interface Department {
    void assignDepartment();
    String getDepartmentDetails();
}

// FullTimeEmployee class
class FullTimeEmployee extends Employee implements Department {
    private String department;
    
    public FullTimeEmployee(String employeeId, String name, double baseSalary) {
        super(employeeId, name, baseSalary);
    }
    
    @Override
    public double calculateSalary() {
        return getBaseSalary(); // Full salary for full-time employees
    }
    
    @Override
    public void assignDepartment() {
        this.department = "Full-Time Department";
    }
    
    @Override
    public String getDepartmentDetails() {
        return department != null ? department : "No department assigned";
    }
}

// PartTimeEmployee class
class PartTimeEmployee extends Employee implements Department {
    private int hoursWorked;
    private double hourlyRate;
    private String department;
    
    public PartTimeEmployee(String employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }
    
    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }
    
    @Override
    public void assignDepartment() {
        this.department = "Part-Time Department";
    }
    
    @Override
    public String getDepartmentDetails() {
        return department != null ? department : "No department assigned";
    }
    
    public int getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(int hoursWorked) { this.hoursWorked = hoursWorked; }
    
    public double getHourlyRate() { return hourlyRate; }
    public void setHourlyRate(double hourlyRate) { this.hourlyRate = hourlyRate; }
}

// Main class to demonstrate
public class EmployeeManagement {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        
        FullTimeEmployee ft1 = new FullTimeEmployee("FT001", "John Doe", 50000);
        PartTimeEmployee pt1 = new PartTimeEmployee("PT001", "Jane Smith", 0, 20, 25);
        
        ft1.assignDepartment();
        pt1.assignDepartment();
        
        employees.add(ft1);
        employees.add(pt1);
        
        // Polymorphism demonstration
        for (Employee emp : employees) {
            emp.displayDetails();
            if (emp instanceof Department) {
                System.out.println("Department: " + ((Department) emp).getDepartmentDetails());
            }
            System.out.println("---");
        }
    }
}
