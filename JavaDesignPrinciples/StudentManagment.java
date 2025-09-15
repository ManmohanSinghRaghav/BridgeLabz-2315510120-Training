import java.util.ArrayList;
import java.util.List;

class Student {
    // Static variables
    private static String universityName = "Tech University";
    private static int totalStudents = 0;
    
    // Instance variables
    private String name;
    private final int rollNumber;
    private double marks;
    private List<Course> enrolledCourses; // Association with Course
    
    // Constructor using 'this' keyword
    public Student(String name, int rollNumber, double marks) {
        this.name = name; // 'this' resolves ambiguity
        this.rollNumber = rollNumber; // final variable
        this.marks = marks;
        this.enrolledCourses = new ArrayList<>();
        totalStudents++;
    }
    
    // Method to enroll in a course (Association)
    public void enrollInCourse(Course course) {
        if (course != null && !enrolledCourses.contains(course)) {
            enrolledCourses.add(course);
            course.addStudent(this); // Communication between objects
            System.out.println(name + " enrolled in " + course.getCourseName());
        }
    }
    
    // Method to view enrolled courses
    public void viewEnrolledCourses() {
        System.out.println("=== " + name + "'s Enrolled Courses ===");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course course : enrolledCourses) {
                System.out.println("- " + course.getCourseName() + " (" + course.getCredits() + " credits)");
            }
        }
    }
    
    // Method to calculate grade based on marks
    public char calculateGrade() {
        if (marks >= 90) return 'A';
        else if (marks >= 80) return 'B';
        else if (marks >= 70) return 'C';
        else if (marks >= 60) return 'D';
        else return 'F';
    }
    
    // Static method to display student details with instanceof check
    public static void displayStudentReport(Object obj) {
        if (obj instanceof Student) {
            Student student = (Student) obj;
            System.out.println("=== Student Report ===");
            System.out.println("University: " + universityName);
            System.out.println("Name: " + student.name);
            System.out.println("Roll Number: " + student.rollNumber);
            System.out.println("Marks: " + student.marks);
            System.out.println("Grade: " + student.calculateGrade());
            System.out.println("Total Courses: " + student.enrolledCourses.size());
        } else {
            System.out.println("Error: Object is not a Student instance!");
        }
    }
    
    // Getters
    public String getName() {
        return this.name;
    }
    
    public int getRollNumber() {
        return this.rollNumber;
    }
    
    public double getMarks() {
        return this.marks;
    }
    
    public List<Course> getEnrolledCourses() {
        return new ArrayList<>(enrolledCourses); // Return copy for encapsulation
    }
    
    public static int getTotalStudents() {
        return totalStudents;
    }
    
    public static void main(String[] args) {
        // Create courses
        Course javaCourse = new Course("Java Programming", "CS101", 3);
        Course mathCourse = new Course("Calculus", "MATH201", 4);
        Course physicsCourse = new Course("Physics", "PHY101", 3);
        
        // Create students
        Student student1 = new Student("Alice Johnson", 101, 85.5);
        Student student2 = new Student("Bob Smith", 102, 92.0);
        Student student3 = new Student("Charlie Brown", 103, 67.8);
        
        // Demonstrate association - students enrolling in courses
        System.out.println("=== Course Enrollment ===");
        student1.enrollInCourse(javaCourse);
        student1.enrollInCourse(mathCourse);
        
        student2.enrollInCourse(javaCourse);
        student2.enrollInCourse(physicsCourse);
        
        student3.enrollInCourse(mathCourse);
        
        // Display student reports
        Student.displayStudentReport(student1);
        student1.viewEnrolledCourses();
        
        System.out.println();
        Student.displayStudentReport(student2);
        student2.viewEnrolledCourses();
        
        // Show course enrollment from course perspective
        System.out.println("\n=== Course Enrollment Summary ===");
        javaCourse.displayEnrolledStudents();
        mathCourse.displayEnrolledStudents();
        
        // Test instanceof with invalid object
        String notAStudent = "Not a student";
        Student.displayStudentReport(notAStudent);
    }
}

// Course class to demonstrate association
class Course {
    private String courseName;
    private final String courseCode; // final variable
    private int credits;
    private List<Student> enrolledStudents; // Association with Student
    
    public Course(String courseName, String courseCode, int credits) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.credits = credits;
        this.enrolledStudents = new ArrayList<>();
    }
    
    // Method to add student (called from Student.enrollInCourse)
    public void addStudent(Student student) {
        if (student != null && !enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }
    
    // Method to display enrolled students
    public void displayEnrolledStudents() {
        System.out.println("=== " + courseName + " Enrolled Students ===");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                System.out.println("- " + student.getName() + " (Roll: " + student.getRollNumber() + ")");
            }
        }
    }
    
    // Getters
    public String getCourseName() {
        return courseName;
    }
    
    public String getCourseCode() {
        return courseCode;
    }
    
    public int getCredits() {
        return credits;
    }
    
    public List<Student> getEnrolledStudents() {
        return new ArrayList<>(enrolledStudents);
    }
}