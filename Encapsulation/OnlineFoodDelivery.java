import java.util.*;

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;
    
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
    
    // Getters and Setters
    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }
    
    public double getPrice() { return price; }
    public void setPrice(double price) { 
        if (price > 0) this.price = price; 
    }
    
    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { 
        if (quantity > 0) this.quantity = quantity; 
    }
    
    // Abstract method
    public abstract double calculateTotalPrice();
    
    // Concrete method
    public String getItemDetails() {
        return "Item: " + itemName + ", Price: $" + price + 
               ", Quantity: " + quantity + ", Total: $" + calculateTotalPrice();
    }
}

// Interface Discountable
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double baseTotal = getPrice() * getQuantity();
        return baseTotal - applyDiscount();
    }
    
    @Override
    public double applyDiscount() {
        return (getPrice() * getQuantity()) * 0.05; // 5% discount for veg items
    }
    
    @Override
    public String getDiscountDetails() {
        return "5% vegetarian discount applied";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private static final double NON_VEG_CHARGE = 2.0; // Additional charge per item
    
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }
    
    @Override
    public double calculateTotalPrice() {
        double baseTotal = (getPrice() + NON_VEG_CHARGE) * getQuantity();
        return baseTotal - applyDiscount();
    }
    
    @Override
    public double applyDiscount() {
        return ((getPrice() + NON_VEG_CHARGE) * getQuantity()) * 0.02; // 2% discount for non-veg items
    }
    
    @Override
    public String getDiscountDetails() {
        return "2% discount applied (Non-veg charge: $" + NON_VEG_CHARGE + " per item)";
    }
}

// Order class to manage food items
class Order {
    private String orderId;
    private List<FoodItem> items;
    private String customerDetails;
    
    public Order(String orderId) {
        this.orderId = orderId;
        this.items = new ArrayList<>();
    }
    
    public void addItem(FoodItem item) {
        items.add(item);
    }
    
    public double calculateOrderTotal() {
        return items.stream().mapToDouble(FoodItem::calculateTotalPrice).sum();
    }
    
    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        for (FoodItem item : items) {
            System.out.println(item.getItemDetails());
            if (item instanceof Discountable) {
                System.out.println("Discount: " + ((Discountable) item).getDiscountDetails());
            }
        }
        System.out.println("Total Order Amount: $" + calculateOrderTotal());
    }
    
    // Encapsulation for customer details
    public void setCustomerDetails(String customerDetails) {
        this.customerDetails = customerDetails;
    }
    
    protected String getCustomerDetails() {
        return customerDetails;
    }
}

public class OnlineFoodDelivery {
    public static void processOrder(Order order) {
        order.displayOrder();
    }
    
    public static void main(String[] args) {
        Order order = new Order("ORD001");
        order.setCustomerDetails("John Doe, 123 Main St");
        
        order.addItem(new VegItem("Veggie Burger", 8.99, 2));
        order.addItem(new NonVegItem("Chicken Pizza", 15.99, 1));
        order.addItem(new VegItem("Salad", 6.99, 1));
        
        processOrder(order);
    }
}
