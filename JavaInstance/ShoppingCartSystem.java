class Product {
    // Static variables shared across all products
    private static double discount = 5.0; // Default 5% discount
    private static int totalProducts = 0;
    
    // Instance variables
    private String productName;
    private final String productID; // Final - cannot be changed once assigned
    private double price;
    private int quantity;
    
    // Constructor using 'this' to resolve ambiguity
    public Product(String productName, String productID, double price, int quantity) {
        this.productName = productName; // 'this' resolves parameter/field ambiguity
        this.productID = productID; // Final variable initialization
        this.price = price;
        this.quantity = quantity;
        totalProducts++; // Increment total products count
    }
    
    // Static method to update discount
    public static void updateDiscount(double discount) {
        if (discount >= 0 && discount <= 50) {
            Product.discount = discount;
            System.out.println("Discount updated to: " + discount + "%");
        } else {
            System.out.println("Invalid discount! Must be between 0% and 50%");
        }
    }
    
    // Static method to get discount
    public static double getDiscount() {
        return discount;
    }
    
    // Static method to get total products
    public static int getTotalProducts() {
        return totalProducts;
    }
    
    // Method to calculate total price with discount
    public double calculateTotalPrice() {
        double totalPrice = this.price * this.quantity;
        double discountAmount = totalPrice * (discount / 100);
        return totalPrice - discountAmount;
    }
    
    // Method to update quantity
    public void updateQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
            System.out.println("Quantity updated to: " + this.quantity);
        } else {
            System.out.println("Invalid quantity!");
        }
    }
    
    // Static method to display product details with instanceof check
    public static void displayProductDetails(Object obj) {
        if (obj instanceof Product) { // Type checking with instanceof
            Product product = (Product) obj; // Safe casting
            System.out.println("=== Product Details ===");
            System.out.println("Product Name: " + product.productName);
            System.out.println("Product ID: " + product.productID);
            System.out.println("Unit Price: $" + product.price);
            System.out.println("Quantity: " + product.quantity);
            System.out.println("Current Discount: " + discount + "%");
            System.out.println("Total Price (with discount): $" + 
                String.format("%.2f", product.calculateTotalPrice()));
        } else {
            System.out.println("Error: Object is not a Product instance!");
        }
    }
    
    // Getters
    public String getProductName() {
        return this.productName;
    }
    
    public String getProductID() {
        return this.productID; // Final variable can be read
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public int getQuantity() {
        return this.quantity;
    }
    
    // Setters with validation
    public void setProductName(String productName) {
        if (productName != null && !productName.trim().isEmpty()) {
            this.productName = productName;
        }
    }
    
    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Shopping Cart System ===");
        System.out.println("Current Discount: " + Product.getDiscount() + "%");
        System.out.println("Initial Total Products: " + Product.getTotalProducts());
        
        // Creating products
        Product product1 = new Product("Laptop", "PROD001", 999.99, 2);
        Product product2 = new Product("Mouse", "PROD002", 25.50, 5);
        Product product3 = new Product("Keyboard", "PROD003", 75.00, 3);
        
        System.out.println("\nTotal Products after creation: " + Product.getTotalProducts());
        
        // Using instanceof to safely display product details
        Product.displayProductDetails(product1);
        
        System.out.println("\n--- Shopping Cart Operations ---");
        product1.updateQuantity(3);
        Product.displayProductDetails(product1);
        
        // Update discount (affects all products)
        System.out.println("\n--- Updating Discount ---");
        Product.updateDiscount(10.0);
        Product.displayProductDetails(product1);
        Product.displayProductDetails(product2);
        
        // Testing instanceof with non-Product object
        Double notAProduct = 123.45;
        System.out.println("\n--- Testing instanceof with invalid object ---");
        Product.displayProductDetails(notAProduct);
        
        // Final variable demonstration
        System.out.println("\n--- Final Variable Demonstration ---");
        System.out.println("Product ID (final): " + product1.getProductID());
        // product1.productID = "NEW-ID"; // This would cause compilation error
        
        // Calculate total cart value
        System.out.println("\n--- Cart Summary ---");
        double cartTotal = product1.calculateTotalPrice() + 
                          product2.calculateTotalPrice() + 
                          product3.calculateTotalPrice();
        System.out.println("Total Cart Value: $" + String.format("%.2f", cartTotal));
    }
}
