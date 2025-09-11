

class Circle {
    // Attribute
    double radius;
    
    // Constructor
    public Circle(double radius) {
        this.radius = radius;
    }
    
    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }
    
    // Method to calculate circumference
    public double calculateCircumference() {
        return 2 * Math.PI * radius;
    }
    
    // Method to display circle details
    public void displayCircleDetails() {
        System.out.println("Circle Radius: " + radius);
        System.out.println("Circle Area: " + String.format("%.2f", calculateArea()));
        System.out.println("Circle Circumference: " + String.format("%.2f", calculateCircumference()));
    }
    
    public static void main(String[] args) {
        Circle circle = new Circle(5.0);
        circle.displayCircleDetails();
        
        System.out.println("\n--- Another Circle ---");
        Circle circle2 = new Circle(7.5);
        circle2.displayCircleDetails();
    }
}