import java.util.ArrayList;
import java.util.List;

// Employee class - exists only within a Department (Composition)
class Employee {
    private String employeeName;
    private final int employeeId; // final variable
    private String position;
    private double salary;
    private String departmentName; // Reference to department
    
    // Package-private constructor (only Department can create employees)
    Employee(String employeeName, int employeeId, String position, 
             double salary, String departmentName) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.position = position;
        this.salary = salary;
        this.departmentName = departmentName;
    }
    
    // Communication method - give raise
    public void giveRaise(double percentage) {
        if (percentage > 0) {
            double oldSalary = this.salary;
            this.salary += (this.salary * percentage / 100);
            System.out.println(employeeName + "'s salary increased from $" + oldSalary + 
                             " to $" + this.salary);
        }
    }
    
    // Communication method - promote employee
    public void promote(String newPosition, double salaryIncrease) {
        this.position = newPosition;
        this.salary += salaryIncrease;
        System.out.println(employeeName + " promoted to " + newPosition + 
                          " with salary increase of $" + salaryIncrease);
    }
    
    // Method to display employee details
    public void displayEmployeeDetails() {
        System.out.println("Name: " + employeeName + ", ID: " + employeeId + 
                          ", Position: " + position + ", Salary: $" + salary + 
                          ", Department: " + departmentName);
    }
    
    // Getters
    public String getEmployeeName() { return employeeName; }
    public int getEmployeeId() { return employeeId; }
    public String getPosition() { return position; }
    public double getSalary() { return salary; }
    public String getDepartmentName() { return departmentName; }
}

// Department class - exists only within a Company (Composition)
class Department {
    private String departmentName;
    private final String departmentCode; // final variable
    private String managerName;
    private List<Employee> employees; // Composition with Employee
    private String companyName; // Reference to company
    private static int nextEmployeeId = 1001;
    
    // Package-private constructor (only Company can create departments)
    Department(String departmentName, String departmentCode, 
               String managerName, String companyName) {
        this.departmentName = departmentName;
        this.departmentCode = departmentCode;
        this.managerName = managerName;
        this.companyName = companyName;
        this.employees = new ArrayList<>();
    }
    
    // Method to add employee (Composition - employee created within department)
    public Employee addEmployee(String employeeName, String position, double salary) {
        Employee employee = new Employee(employeeName, nextEmployeeId++, 
                                       position, salary, this.departmentName);
        employees.add(employee);
        System.out.println("Employee " + employeeName + " added to " + departmentName + " department");
        return employee;
    }
    
    // Communication method - remove employee
    public boolean removeEmployee(int employeeId) {
        Employee toRemove = null;
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employeeId) {
                toRemove = emp;
                break;
            }
        }
        
        if (toRemove != null) {
            employees.remove(toRemove);
            System.out.println("Employee " + toRemove.getEmployeeName() + 
                             " removed from " + departmentName);
            return true;
        } else {
            System.out.println("Employee with ID " + employeeId + " not found");
            return false;
        }
    }
    
    // Communication method - calculate total department salary
    public double calculateTotalSalary() {
        double total = 0;
        for (Employee emp : employees) {
            total += emp.getSalary();
        }
        return total;
    }
    
    // Method to display department details
    public void displayDepartmentDetails() {
        System.out.println("=== " + departmentName + " Department ===");
        System.out.println("Department Code: " + departmentCode);
        System.out.println("Manager: " + managerName);
        System.out.println("Company: " + companyName);
        System.out.println("Number of Employees: " + employees.size());
        System.out.println("Total Salary Budget: $" + calculateTotalSalary());
        
        if (!employees.isEmpty()) {
            System.out.println("Employees:");
            for (Employee emp : employees) {
                System.out.print("  ");
                emp.displayEmployeeDetails();
            }
        }
    }
    
    // Method to find employee by ID
    public Employee findEmployee(int employeeId) {
        for (Employee emp : employees) {
            if (emp.getEmployeeId() == employeeId) {
                return emp;
            }
        }
        return null;
    }
    
    // Getters
    public String getDepartmentName() { return departmentName; }
    public String getDepartmentCode() { return departmentCode; }
    public String getManagerName() { return managerName; }
    public List<Employee> getEmployees() { return new ArrayList<>(employees); }
    public int getEmployeeCount() { return employees.size(); }
}

// Company class - manages departments through composition
class Company {
    private String companyName;
    private String address;
    private List<Department> departments; // Composition with Department
    private static int totalCompanies = 0;
    
    public Company(String companyName, String address) {
        this.companyName = companyName;
        this.address = address;
        this.departments = new ArrayList<>();
        totalCompanies++;
    }
    
    // Method to create department (Composition - department created within company)
    public Department createDepartment(String departmentName, String departmentCode, String managerName) {
        Department department = new Department(departmentName, departmentCode, managerName, this.companyName);
        departments.add(department);
        System.out.println("Department " + departmentName + " created in " + companyName);
        return department;
    }
    
    // Communication method - dissolve department (demonstrates composition)
    public boolean dissolveDepartment(String departmentCode) {
        Department toRemove = null;
        for (Department dept : departments) {
            if (dept.getDepartmentCode().equals(departmentCode)) {
                toRemove = dept;
                break;
            }
        }
        
        if (toRemove != null) {
            departments.remove(toRemove);
            System.out.println("Department " + toRemove.getDepartmentName() + 
                             " dissolved. All employees terminated.");
            // In composition, when department is removed, all employees are also removed
            return true;
        } else {
            System.out.println("Department with code " + departmentCode + " not found");
            return false;
        }
    }
    
    // Communication method - calculate total company payroll
    public double calculateTotalPayroll() {
        double total = 0;
        for (Department dept : departments) {
            total += dept.calculateTotalSalary();
        }
        return total;
    }
    
    // Method to display company overview
    public void displayCompanyOverview() {
        System.out.println("=== " + companyName + " Overview ===");
        System.out.println("Address: " + address);
        System.out.println("Number of Departments: " + departments.size());
        
        int totalEmployees = 0;
        for (Department dept : departments) {
            totalEmployees += dept.getEmployeeCount();
        }
        System.out.println("Total Employees: " + totalEmployees);
        System.out.println("Total Payroll: $" + calculateTotalPayroll());
        
        if (!departments.isEmpty()) {
            System.out.println("\nDepartments:");
            for (Department dept : departments) {
                System.out.println("- " + dept.getDepartmentName() + 
                                 " (" + dept.getEmployeeCount() + " employees)");
            }
        }
    }
    
    // Method to display detailed company information
    public void displayDetailedCompanyInfo() {
        System.out.println("=== Detailed " + companyName + " Information ===");
        if (departments.isEmpty()) {
            System.out.println("No departments found.");
        } else {
            for (Department dept : departments) {
                dept.displayDepartmentDetails();
                System.out.println();
            }
        }
    }
    
    // Static method with instanceof check
    public static void displayCompanyInfo(Object obj) {
        if (obj instanceof Company) {
            Company company = (Company) obj;
            company.displayCompanyOverview();
        } else {
            System.out.println("Error: Object is not a Company instance!");
        }
    }
    
    // Method to find department by code
    public Department findDepartment(String departmentCode) {
        for (Department dept : departments) {
            if (dept.getDepartmentCode().equals(departmentCode)) {
                return dept;
            }
        }
        return null;
    }
    
    // Getters
    public String getCompanyName() { return companyName; }
    public String getAddress() { return address; }
    public List<Department> getDepartments() { return new ArrayList<>(departments); }
    public static int getTotalCompanies() { return totalCompanies; }
    
    public static void main(String[] args) {
        // Create company
        Company techCorp = new Company("TechCorp Solutions", "123 Tech Street, Silicon Valley");
        
        // Create departments (Composition)
        System.out.println("=== Creating Departments ===");
        Department engineering = techCorp.createDepartment("Engineering", "ENG01", "John Smith");
        Department marketing = techCorp.createDepartment("Marketing", "MKT01", "Sarah Johnson");
        Department hr = techCorp.createDepartment("Human Resources", "HR01", "Mike Brown");
        
        // Add employees to departments (Composition)
        System.out.println("\n=== Adding Employees ===");
        Employee emp1 = engineering.addEmployee("Alice Wilson", "Software Engineer", 75000);
        Employee emp2 = engineering.addEmployee("Bob Davis", "Senior Developer", 85000);
        Employee emp3 = engineering.addEmployee("Charlie Miller", "DevOps Engineer", 80000);
        
        Employee emp4 = marketing.addEmployee("Diana Clark", "Marketing Specialist", 55000);
        Employee emp5 = marketing.addEmployee("Eve Rodriguez", "Content Manager", 60000);
        
        Employee emp6 = hr.addEmployee("Frank Taylor", "HR Coordinator", 50000);
        
        // Display company overview
        System.out.println("\n=== Company Overview ===");
        techCorp.displayCompanyOverview();
        
        // Demonstrate communication between objects
        System.out.println("\n=== Employee Operations ===");
        emp1.giveRaise(10); // 10% raise
        emp2.promote("Lead Developer", 5000);
        
        // Display detailed department information
        System.out.println("\n=== Department Details ===");
        engineering.displayDepartmentDetails();
        
        // Demonstrate composition - dissolving department removes all employees
        System.out.println("\n=== Demonstrating Composition ===");
        System.out.println("Before dissolving HR department:");
        techCorp.displayCompanyOverview();
        
        techCorp.dissolveDepartment("HR01"); // This removes department and all its employees
        
        System.out.println("\nAfter dissolving HR department:");
        techCorp.displayCompanyOverview();
        
        // Test instanceof
        System.out.println("\n=== Testing instanceof ===");
        Company.displayCompanyInfo(techCorp);
        Company.displayCompanyInfo("Not a company");
        
        // Show that employees cannot exist without department (composition)
        System.out.println("\n=== Final Company Details ===");
        techCorp.displayDetailedCompanyInfo();
        
        System.out.println("Total Companies Created: " + Company.getTotalCompanies());
    }
}
