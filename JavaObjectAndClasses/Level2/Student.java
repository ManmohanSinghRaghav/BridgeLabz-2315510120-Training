

class Student {
    // Attributes
    String name;
    int rollNumber;
    double marks;
    
    // Constructor
    public Student(String name, int rollNumber, double marks) {
        this.name = name;
        this.rollNumber = rollNumber;
        this.marks = marks;
    }
    
    // Method to calculate grade based on marks
    public char calculateGrade() {
        if (marks >= 90) {
            return 'A';
        } else if (marks >= 80) {
            return 'B';
        } else if (marks >= 70) {
            return 'C';
        } else if (marks >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }
    
    // Method to display student details and grade
    public void displayStudentReport() {
        System.out.println("Student Report:");
        System.out.println("Name: " + name);
        System.out.println("Roll Number: " + rollNumber);
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
    
    public static void main(String[] args) {
        Student student1 = new Student("Alice Johnson", 101, 85.5);
        student1.displayStudentReport();
        
        System.out.println("\n--- Another Student ---");
        Student student2 = new Student("Bob Smith", 102, 92.0);
        student2.displayStudentReport();
        
        System.out.println("\n--- Another Student ---");
        Student student3 = new Student("Charlie Brown", 103, 67.8);
        student3.displayStudentReport();
    }
}