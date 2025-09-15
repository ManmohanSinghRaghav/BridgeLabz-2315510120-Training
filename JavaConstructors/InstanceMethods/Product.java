

class Product {
    // Instance variables
    private String productName;
    private double price;
    
    // Class variable (static)
    private static int totalProducts = 0;
    
    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment total products count
    }
    
    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }
    
    // Class method (static) to display total products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }
    
    // Getters
    public String getProductName() {
        return productName;
    }
    
    public double getPrice() {
        return price;
    }
    
    public static int getTotalProducts() {
        return totalProducts;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Product Inventory System ===");
        
        // Initially no products
        Product.displayTotalProducts();
        
        // Creating products
        Product product1 = new Product("Laptop", 999.99);
        product1.displayProductDetails();
        Product.displayTotalProducts();
        
        System.out.println();
        Product product2 = new Product("Mouse", 25.50);
        product2.displayProductDetails();
        Product.displayTotalProducts();
        
        System.out.println();
        Product product3 = new Product("Keyboard", 75.00);
        product3.displayProductDetails();
        Product.displayTotalProducts();
        
        System.out.println("\n=== Final Summary ===");
        Product.displayTotalProducts();
    }
}