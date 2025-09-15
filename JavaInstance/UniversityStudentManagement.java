class Student {
    // Static variables shared across all students
    private static String universityName = "Tech University";
    private static int totalStudents = 0;
    
    // Instance variables
    private String name;
    private final int rollNumber; // Final - cannot be changed once assigned
    private String grade;
    private double gpa;
    
    // Constructor using 'this' to resolve ambiguity
    public Student(String name, int rollNumber, String grade, double gpa) {
        this.name = name; // 'this' resolves parameter/field ambiguity
        this.rollNumber = rollNumber; // Final variable initialization
        this.grade = grade;
        this.gpa = gpa;
        totalStudents++; // Increment total students count
    }
    
    // Static method to display total students
    public static void displayTotalStudents() {
        System.out.println("Total Students Enrolled: " + totalStudents);
    }
    
    // Static method to get/set university name
    public static String getUniversityName() {
        return universityName;
    }
    
    public static void setUniversityName(String universityName) {
        Student.universityName = universityName;
    }
    
    // Method to update grade and GPA
    public void updateGrade(String grade, double gpa) {
        if (gpa >= 0.0 && gpa <= 4.0) {
            this.grade = grade;
            this.gpa = gpa;
            System.out.println("Grade updated to: " + this.grade + " (GPA: " + this.gpa + ")");
        } else {
            System.out.println("Invalid GPA! Must be between 0.0 and 4.0");
        }
    }
    
    // Method to calculate grade from GPA
    public String calculateLetterGrade() {
        if (this.gpa >= 3.7) return "A";
        else if (this.gpa >= 3.3) return "B+";
        else if (this.gpa >= 3.0) return "B";
        else if (this.gpa >= 2.7) return "C+";
        else if (this.gpa >= 2.0) return "C";
        else return "F";
    }
    
    // Static method to display student details with instanceof check
    public static void displayStudentDetails(Object obj) {
        if (obj instanceof Student) { // Type checking with instanceof
            Student student = (Student) obj; // Safe casting
            System.out.println("=== Student Details ===");
            System.out.println("University: " + universityName);
            System.out.println("Name: " + student.name);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Grade: " + student.grade);
            System.out.println("GPA: " + student.gpa);
            System.out.println("Letter Grade: " + student.calculateLetterGrade());
        } else {
            System.out.println("Error: Object is not a Student instance!");
        }
    }
    
    // Static method to perform grade operations with type checking
    public static void performGradeOperation(Object obj, String newGrade, double newGpa) {
        if (obj instanceof Student) { // Safe type checking
            Student student = (Student) obj;
            student.updateGrade(newGrade, newGpa);
        } else {
            System.out.println("Error: Cannot perform grade operation on non-Student object!");
        }
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getRollNumber() {
        return this.rollNumber; // Final variable can be read
    }
    
    public String getGrade() {
        return this.grade;
    }
    
    public double getGpa() {
        return this.gpa;
    }
    
    // Setter with validation
    public void setName(String name) {
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== University Student Management System ===");
        System.out.println("University: " + Student.getUniversityName());
        Student.displayTotalStudents();
        
        // Creating students
        Student student1 = new Student("Alice Johnson", 2023001, "A", 3.8);
        Student student2 = new Student("Bob Smith", 2023002, "B+", 3.4);
        Student student3 = new Student("Charlie Brown", 2023003, "B", 3.1);
        
        System.out.println();
        Student.displayTotalStudents();
        
        // Using instanceof to safely display student details
        Student.displayStudentDetails(student1);
        
        System.out.println("\n--- Student Operations ---");
        Student.performGradeOperation(student1, "A+", 4.0);
        Student.displayStudentDetails(student1);
        
        // Testing instanceof with non-Student object
        String notAStudent = "Not a student";
        System.out.println("\n--- Testing instanceof with invalid object ---");
        Student.displayStudentDetails(notAStudent);
        Student.performGradeOperation(notAStudent, "A", 4.0);
        
        // Final variable demonstration
        System.out.println("\n--- Final Variable Demonstration ---");
        System.out.println("Student Roll Number (final): " + student1.getRollNumber());
        // student1.rollNumber = 999999; // This would cause compilation error
        
        // Static variable change affects all students
        System.out.println("\n--- Changing University Name ---");
        Student.setUniversityName("Global Tech University");
        Student.displayStudentDetails(student2);
        Student.displayStudentDetails(student3);
        
        // Display all students' letter grades
        System.out.println("\n--- All Students Grade Summary ---");
        System.out.println(student1.getName() + ": " + student1.calculateLetterGrade());
        System.out.println(student2.getName() + ": " + student2.calculateLetterGrade());
        System.out.println(student3.getName() + ": " + student3.calculateLetterGrade());
    }
}
