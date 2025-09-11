

class Item {
    // Attributes
    String itemCode;
    String itemName;
    double price;
    
    // Constructor
    public Item(String itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    
    // Method to display item details
    public void displayItemDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per unit: $" + price);
    }
    
    // Method to calculate total cost for given quantity
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    
    // Method to display total cost details
    public void displayTotalCost(int quantity) {
        double totalCost = calculateTotalCost(quantity);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + totalCost);
    }
    
    public static void main(String[] args) {
        Item item1 = new Item("ITM001", "Laptop", 899.99);
        item1.displayItemDetails();
        item1.displayTotalCost(3);
        
        System.out.println("\n--- Another Item ---");
        Item item2 = new Item("ITM002", "Mouse", 25.50);
        item2.displayItemDetails();
        item2.displayTotalCost(10);
    }
}