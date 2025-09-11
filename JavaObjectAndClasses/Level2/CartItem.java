

class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;
    
    // Constructor
    public CartItem(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = 0;
    }
    
    // Method to add item to cart
    public void addItem(int quantity) {
        if (quantity > 0) {
            this.quantity += quantity;
            System.out.println("Added " + quantity + " units of " + itemName + " to cart.");
        } else {
            System.out.println("Invalid quantity!");
        }
    }
    
    // Method to remove item from cart
    public void removeItem(int quantity) {
        if (quantity > 0 && quantity <= this.quantity) {
            this.quantity -= quantity;
            System.out.println("Removed " + quantity + " units of " + itemName + " from cart.");
        } else if (quantity > this.quantity) {
            System.out.println("Cannot remove " + quantity + " units. Only " + this.quantity + " units available in cart.");
        } else {
            System.out.println("Invalid quantity!");
        }
    }
    
    // Method to calculate total cost
    public double calculateTotalCost() {
        return price * quantity;
    }
    
    // Method to display total cost
    public void displayTotalCost() {
        System.out.println("=== Cart Summary ===");
        System.out.println("Item: " + itemName);
        System.out.println("Price per unit: $" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
    
    public static void main(String[] args) {
        CartItem item1 = new CartItem("Wireless Headphones", 99.99);
        item1.displayTotalCost();
        
        System.out.println("\n--- Adding Items ---");
        item1.addItem(2);
        item1.displayTotalCost();
        
        System.out.println("\n--- Adding More Items ---");
        item1.addItem(1);
        item1.displayTotalCost();
        
        System.out.println("\n--- Removing Items ---");
        item1.removeItem(1);
        item1.displayTotalCost();
        
        System.out.println("\n--- Another Cart Item ---");
        CartItem item2 = new CartItem("Gaming Mouse", 45.50);
        item2.addItem(3);
        item2.displayTotalCost();
    }
}