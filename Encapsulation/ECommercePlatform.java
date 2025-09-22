import java.util.*;

// Abstract class Product
abstract class Product {
    private String productId;
    private String name;
    private double price;
    
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    
    // Getters and Setters
    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { 
        if (price > 0) this.price = price; 
    }
    
    public abstract double calculateDiscount();
    
    public double getFinalPrice() {
        double tax = this instanceof Taxable ? ((Taxable) this).calculateTax() : 0;
        return price + tax - calculateDiscount();
    }
}

// Interface Taxable
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.1; // 10% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 18% applied";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.15; // 15% discount
    }
    
    @Override
    public double calculateTax() {
        return getPrice() * 0.12; // 12% GST
    }
    
    @Override
    public String getTaxDetails() {
        return "GST 12% applied";
    }
}

// Groceries class
class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }
    
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }
}

public class ECommercePlatform {
    public static void calculateAndPrintFinalPrice(List<Product> products) {
        for (Product product : products) {
            System.out.println("Product: " + product.getName());
            System.out.println("Original Price: $" + product.getPrice());
            System.out.println("Discount: $" + product.calculateDiscount());
            if (product instanceof Taxable) {
                Taxable taxableProduct = (Taxable) product;
                System.out.println("Tax: $" + taxableProduct.calculateTax());
                System.out.println("Tax Details: " + taxableProduct.getTaxDetails());
            }
            System.out.println("Final Price: $" + product.getFinalPrice());
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Electronics("E001", "Laptop", 1000));
        products.add(new Clothing("C001", "T-Shirt", 50));
        products.add(new Groceries("G001", "Rice", 20));
        
        calculateAndPrintFinalPrice(products);
    }
}
