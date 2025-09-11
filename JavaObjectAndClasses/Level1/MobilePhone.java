

class MobilePhone {
    // Attributes
    String brand;
    String model;
    double price;
    
    // Constructor
    public MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
    
    // Method to display all phone details
    public void displayPhoneDetails() {
        System.out.println("Mobile Phone Details:");
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Price: $" + price);
    }
    
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone("Samsung", "Galaxy S23", 799.99);
        phone1.displayPhoneDetails();
        
        System.out.println("\n--- Another Phone ---");
        MobilePhone phone2 = new MobilePhone("Apple", "iPhone 14", 999.99);
        phone2.displayPhoneDetails();
        
        System.out.println("\n--- Another Phone ---");
        MobilePhone phone3 = new MobilePhone("Google", "Pixel 7", 599.99);
        phone3.displayPhoneDetails();
    }
}