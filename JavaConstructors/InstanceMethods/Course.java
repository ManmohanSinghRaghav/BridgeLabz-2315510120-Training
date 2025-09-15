

class Course {
    // Instance variables
    private String courseName;
    private int duration; // in hours
    private double fee;
    
    // Class variable (static) - common for all courses
    private static String instituteName = "Tech Institute";
    
    // Constructor
    public Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }
    
    // Instance method to display course details
    public void displayCourseDetails() {
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " hours");
        System.out.println("Fee: $" + fee);
        System.out.println("Institute: " + instituteName);
    }
    
    // Class method (static) to update institute name
    public static void updateInstituteName(String newInstituteName) {
        instituteName = newInstituteName;
        System.out.println("Institute name updated to: " + instituteName);
    }
    
    // Getters
    public String getCourseName() {
        return courseName;
    }
    
    public int getDuration() {
        return duration;
    }
    
    public double getFee() {
        return fee;
    }
    
    public static String getInstituteName() {
        return instituteName;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Online Course Management System ===");
        
        // Creating courses
        Course course1 = new Course("Java Programming", 40, 299.99);
        Course course2 = new Course("Python Basics", 30, 199.99);
        Course course3 = new Course("Web Development", 60, 399.99);
        
        System.out.println("--- Initial Course Details ---");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();
        course3.displayCourseDetails();
        
        System.out.println("\n--- Updating Institute Name ---");
        Course.updateInstituteName("Advanced Tech Academy");
        
        System.out.println("\n--- Course Details After Institute Name Update ---");
        course1.displayCourseDetails();
        System.out.println();
        course2.displayCourseDetails();
        System.out.println();
        course3.displayCourseDetails();
        
        System.out.println("\n--- Current Institute Name ---");
        System.out.println("Institute: " + Course.getInstituteName());
    }
}