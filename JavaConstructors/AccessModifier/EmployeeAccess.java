class EmployeeAccess {
    public int employeeID;        // Public access
    protected String department;  // Protected access
    private double salary;        // Private access
    
    // Constructor
    public EmployeeAccess(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        setSalary(salary); // Use setter for validation
    }
    
    // Public methods to access and modify private salary
    public double getSalary() {
        return salary;
    }
    
    public void setSalary(double salary) {
        if (salary >= 0) {
            this.salary = salary;
        } else {
            System.out.println("Salary cannot be negative");
            this.salary = 0.0;
        }
    }
    
    // Method to give raise
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double raiseAmount = salary * (percentage / 100);
            salary += raiseAmount;
            System.out.println("Salary raised by " + percentage + "%. New salary: $" + salary);
        } else {
            System.out.println("Raise percentage must be positive");
        }
    }
    
    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Employee ID: " + employeeID);
        System.out.println("Department: " + department);
        System.out.println("Salary: $" + salary);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Employee Records System ===");
        
        EmployeeAccess employee = new EmployeeAccess(101, "Engineering", 75000.0);
        employee.displayEmployeeDetails();
        
        System.out.println("\n--- Accessing Public Member ---");
        System.out.println("Employee ID (direct access): " + employee.employeeID);
        
        System.out.println("\n--- Modifying Salary using public method ---");
        employee.setSalary(80000.0);
        System.out.println("Updated Salary: $" + employee.getSalary());
        
        System.out.println("\n--- Giving Raise ---");
        employee.giveRaise(10.0);
        
        System.out.println("\n--- Testing Invalid Salary ---");
        employee.setSalary(-5000.0); // Invalid salary
        System.out.println("Salary after invalid input: $" + employee.getSalary());
    }
}

// Subclass to demonstrate access modifiers
class Manager extends EmployeeAccess {
    private int teamSize;
    private double bonus;
    
    public Manager(int employeeID, String department, double salary, int teamSize, double bonus) {
        super(employeeID, department, salary);
        this.teamSize = teamSize;
        this.bonus = bonus;
    }
    
    // Method to calculate total compensation
    public double calculateTotalCompensation() {
        return getSalary() + bonus; // Private salary accessed via public method
    }
    
    // Override to give manager-specific raise
    @Override
    public void giveRaise(double percentage) {
        super.giveRaise(percentage);
        // Also increase bonus by half the percentage
        bonus += bonus * (percentage / 200);
        System.out.println("Bonus also increased. New bonus: $" + bonus);
    }
    
    public void displayManagerDetails() {
        System.out.println("=== Manager Details ===");
        System.out.println("Employee ID: " + employeeID);     // Public - accessible
        System.out.println("Department: " + department);      // Protected - accessible in subclass
        System.out.println("Salary: $" + getSalary());        // Private - accessed via public method
        System.out.println("Team Size: " + teamSize);
        System.out.println("Bonus: $" + bonus);
        System.out.println("Total Compensation: $" + calculateTotalCompensation());
    }
    
    public int getTeamSize() {
        return teamSize;
    }
    
    public double getBonus() {
        return bonus;
    }
}
