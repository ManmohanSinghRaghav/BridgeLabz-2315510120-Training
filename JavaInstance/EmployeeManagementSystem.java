class Employee {
    // Static variables shared across all employees
    private static String companyName = "TechCorp Solutions";
    private static int totalEmployees = 0;
    
    // Instance variables
    private String name;
    private final int id; // Final - cannot be changed once assigned
    private String designation;
    private double salary;
    
    // Constructor using 'this' to resolve ambiguity
    public Employee(String name, int id, String designation, double salary) {
        this.name = name; // 'this' resolves parameter/field ambiguity
        this.id = id; // Final variable initialization
        this.designation = designation;
        this.salary = salary;
        totalEmployees++; // Increment total employees count
    }
    
    // Static method to display total employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }
    
    // Static method to get/set company name
    public static String getCompanyName() {
        return companyName;
    }
    
    public static void setCompanyName(String companyName) {
        Employee.companyName = companyName;
    }
    
    // Method to give raise
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = this.salary * (percentage / 100);
            this.salary += raiseAmount;
            System.out.println("Salary raised by " + percentage + "%. New salary: $" + this.salary);
        } else {
            System.out.println("Invalid raise percentage!");
        }
    }
    
    // Method to update designation
    public void updateDesignation(String designation) {
        this.designation = designation;
        System.out.println("Designation updated to: " + this.designation);
    }
    
    // Static method to display employee details with instanceof check
    public static void displayEmployeeDetails(Object obj) {
        if (obj instanceof Employee) { // Type checking with instanceof
            Employee employee = (Employee) obj; // Safe casting
            System.out.println("=== Employee Details ===");
            System.out.println("Company: " + companyName);
            System.out.println("Name: " + employee.name);
            System.out.println("ID: " + employee.id);
            System.out.println("Designation: " + employee.designation);
            System.out.println("Salary: $" + employee.salary);
        } else {
            System.out.println("Error: Object is not an Employee instance!");
        }
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getId() {
        return this.id; // Final variable can be read
    }
    
    public String getDesignation() {
        return this.designation;
    }
    
    public double getSalary() {
        return this.salary;
    }
    
    // Setter with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Employee Management System ===");
        System.out.println("Company: " + Employee.getCompanyName());
        Employee.displayTotalEmployees();
        
        // Creating employees
        Employee emp1 = new Employee("John Smith", 101, "Software Engineer", 75000);
        Employee emp2 = new Employee("Alice Johnson", 102, "Project Manager", 85000);
        Employee emp3 = new Employee("Bob Wilson", 103, "QA Engineer", 65000);
        
        System.out.println();
        Employee.displayTotalEmployees();
        
        // Using instanceof to safely display employee details
        Employee.displayEmployeeDetails(emp1);
        
        System.out.println("\n--- Employee Operations ---");
        emp1.giveRaise(10.0);
        emp1.updateDesignation("Senior Software Engineer");
        Employee.displayEmployeeDetails(emp1);
        
        // Testing instanceof with non-Employee object
        Integer notAnEmployee = 12345;
        System.out.println("\n--- Testing instanceof with invalid object ---");
        Employee.displayEmployeeDetails(notAnEmployee);
        
        // Final variable demonstration
        System.out.println("\n--- Final Variable Demonstration ---");
        System.out.println("Employee ID (final): " + emp1.getId());
        // emp1.id = 999; // This would cause compilation error
        
        // Static variable change affects all employees
        System.out.println("\n--- Changing Company Name ---");
        Employee.setCompanyName("Global Tech Solutions");
        Employee.displayEmployeeDetails(emp2);
        Employee.displayEmployeeDetails(emp3);
    }
}
