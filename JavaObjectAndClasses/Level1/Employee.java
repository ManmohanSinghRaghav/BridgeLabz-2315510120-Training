

class Employee {
    // Non-static variables
    String name;
    int id;
    double salary;
    
    // Constructor to initialize employee details
    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    
    // Default constructor
    public Employee() {
        this.name = "Rohan";
        this.id = 1;
        this.salary = 500000.0;
    }
    
    // Creating method to display employee details
    public void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee id: " + id);
        System.out.println("Employee Salary: " + salary);
    }
    
    public static void main(String[] args) {
        Employee emp = new Employee(); // Creating object with default constructor
        emp.displayEmployee(); // Calling the display method
        
        System.out.println("\n--- Another Employee ---");
        Employee emp2 = new Employee("Alice", 2, 750000.0);
        emp2.displayEmployee();
    }
}