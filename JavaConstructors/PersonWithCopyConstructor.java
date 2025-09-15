

class PersonWithCopyConstructor {
    private String name;
    private int age;
    private String email;
    
    // Default constructor with constructor chaining
    public PersonWithCopyConstructor() {
        this("Unknown", 0, "unknown@email.com");
    }
    
    // Parameterized constructor with validation
    public PersonWithCopyConstructor(String name, int age, String email) {
        this.name = validateName(name);
        this.age = validateAge(age);
        this.email = validateEmail(email);
    }
    
    // Copy constructor
    public PersonWithCopyConstructor(PersonWithCopyConstructor other) {
        this.name = other.name;
        this.age = other.age;
        this.email = other.email;
    }
    
    // Private validation methods (encapsulated logic)
    private String validateName(String name) {
        return (name != null && !name.trim().isEmpty()) ? name : "Unknown";
    }
    
    private int validateAge(int age) {
        return (age >= 0 && age <= 150) ? age : 0;
    }
    
    private String validateEmail(String email) {
        return (email != null && email.contains("@")) ? email : "unknown@email.com";
    }
    
    // Getters
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Setters with validation
    public void setName(String name) {
        this.name = validateName(name);
    }
    
    public void setAge(int age) {
        this.age = validateAge(age);
    }
    
    public void setEmail(String email) {
        this.email = validateEmail(email);
    }
    
    // Method to display person details
    public void displayPersonDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Email: " + email);
    }
    
    public static void main(String[] args) {
        // Using default constructor (with chaining)
        PersonWithCopyConstructor person1 = new PersonWithCopyConstructor();
        System.out.println("=== Person with Default Constructor ===");
        person1.displayPersonDetails();
        
        // Using parameterized constructor
        PersonWithCopyConstructor person2 = new PersonWithCopyConstructor("John Doe", 30, "john@email.com");
        System.out.println("\n=== Person with Parameterized Constructor ===");
        person2.displayPersonDetails();
        
        // Using copy constructor
        PersonWithCopyConstructor person3 = new PersonWithCopyConstructor(person2);
        System.out.println("\n=== Person with Copy Constructor ===");
        person3.displayPersonDetails();
        
        // Modify copied person to show independence
        person3.setName("Jane Doe");
        person3.setAge(28);
        System.out.println("\n=== After Modifying Copied Person ===");
        System.out.println("Original Person:");
        person2.displayPersonDetails();
        System.out.println("\nModified Copy:");
        person3.displayPersonDetails();
        
        // Testing validation
        PersonWithCopyConstructor person4 = new PersonWithCopyConstructor("", 200, "invalid-email");
        System.out.println("\n=== Person with Invalid Data (Validated) ===");
        person4.displayPersonDetails();
    }
}