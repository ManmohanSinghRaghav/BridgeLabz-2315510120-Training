class Student {
    public int rollNumber;        // Public access
    protected String name;        // Protected access
    private double CGPA;          // Private access
    
    // Constructor
    public Student(int rollNumber, String name, double CGPA) {
        this.rollNumber = rollNumber;
        this.name = name;
        setCGPA(CGPA); // Use setter for validation
    }
    
    // Public methods to access and modify private CGPA
    public double getCGPA() {
        return CGPA;
    }
    
    public void setCGPA(double CGPA) {
        if (CGPA >= 0.0 && CGPA <= 10.0) {
            this.CGPA = CGPA;
        } else {
            System.out.println("Invalid CGPA. Must be between 0.0 and 10.0");
            this.CGPA = 0.0;
        }
    }
    
    // Method to display student details
    public void displayStudentDetails() {
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + CGPA);
    }
    
    public static void main(String[] args) {
        System.out.println("=== University Management System ===");
        
        Student student = new Student(101, "John Smith", 8.5);
        student.displayStudentDetails();
        
        System.out.println("\n--- Accessing Public Member ---");
        System.out.println("Roll Number (direct access): " + student.rollNumber);
        
        System.out.println("\n--- Modifying CGPA using public method ---");
        student.setCGPA(9.2);
        System.out.println("Updated CGPA: " + student.getCGPA());
        
        System.out.println("\n--- Testing Invalid CGPA ---");
        student.setCGPA(11.0); // Invalid CGPA
        System.out.println("CGPA after invalid input: " + student.getCGPA());
    }
}

// Subclass to demonstrate protected access
class PostgraduateStudent extends Student {
    private String researchArea;
    
    public PostgraduateStudent(int rollNumber, String name, double CGPA, String researchArea) {
        super(rollNumber, name, CGPA);
        this.researchArea = researchArea;
    }
    
    public void displayPostgradDetails() {
        System.out.println("=== Postgraduate Student Details ===");
        System.out.println("Roll Number: " + rollNumber);     // Public - accessible
        System.out.println("Name: " + name);                  // Protected - accessible in subclass
        System.out.println("CGPA: " + getCGPA());            // Private - accessed via public method
        System.out.println("Research Area: " + researchArea);
    }
    
    public String getResearchArea() {
        return researchArea;
    }
}