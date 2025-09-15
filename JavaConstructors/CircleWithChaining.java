

class CircleWithChaining {
    private double radius;
    private static final double DEFAULT_RADIUS = 1.0;
    
    // Default constructor - uses constructor chaining
    public CircleWithChaining() {
        this(DEFAULT_RADIUS); // Calls parameterized constructor
    }
    
    // Parameterized constructor
    public CircleWithChaining(double radius) {
        this.radius = radius > 0 ? radius : DEFAULT_RADIUS;
    }
    
    // Private method for calculations (encapsulated logic)
    private double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    private double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    
    // Getter
    public double getRadius() {
        return radius;
    }
    
    // Method to display circle details
    public void displayCircleDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Circumference: " + String.format("%.2f", calculateCircumference()));
    }
    
    public static void main(String[] args) {
        // Using default constructor (constructor chaining)
        CircleWithChaining circle1 = new CircleWithChaining();
        System.out.println("=== Circle with Default Constructor ===");
        circle1.displayCircleDetails();
        
        // Using parameterized constructor
        CircleWithChaining circle2 = new CircleWithChaining(5.5);
        System.out.println("\n=== Circle with Parameterized Constructor ===");
        circle2.displayCircleDetails();
        
        // Testing with invalid radius
        CircleWithChaining circle3 = new CircleWithChaining(-3.0);
        System.out.println("\n=== Circle with Invalid Radius (handled) ===");
        circle3.displayCircleDetails();
    }
}