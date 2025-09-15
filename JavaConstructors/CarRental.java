

class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;
    
    // Default constructor
    public CarRental() {
        this.customerName = "Unknown Customer";
        this.carModel = "Economy Car";
        this.rentalDays = 1;
        this.dailyRate = calculateDailyRate();
    }
    
    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays > 0 ? rentalDays : 1;
        this.dailyRate = calculateDailyRate();
    }
    
    // Private method to calculate daily rate based on car model
    private double calculateDailyRate() {
        switch (carModel.toLowerCase()) {
            case "economy car":
                return 30.0;
            case "compact car":
                return 45.0;
            case "suv":
                return 70.0;
            case "luxury car":
                return 120.0;
            default:
                return 30.0;
        }
    }
    
    // Method to calculate total cost
    public double calculateTotalCost() {
        double baseCost = rentalDays * dailyRate;
        // Apply discount for longer rentals
        if (rentalDays >= 7) {
            baseCost *= 0.9; // 10% discount for week+ rentals
        } else if (rentalDays >= 3) {
            baseCost *= 0.95; // 5% discount for 3+ day rentals
        }
        return baseCost;
    }
    
    // Getters
    public String getCustomerName() {
        return customerName;
    }
    
    public String getCarModel() {
        return carModel;
    }
    
    public int getRentalDays() {
        return rentalDays;
    }
    
    public double getDailyRate() {
        return dailyRate;
    }
    
    // Method to display rental details
    public void displayRentalDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Total Cost: $" + String.format("%.2f", calculateTotalCost()));
        
        // Show discount info
        if (rentalDays >= 7) {
            System.out.println("Discount Applied: 10% (7+ days)");
        } else if (rentalDays >= 3) {
            System.out.println("Discount Applied: 5% (3+ days)");
        }
    }
    
    public static void main(String[] args) {
        // Using default constructor
        CarRental rental1 = new CarRental();
        System.out.println("=== Default Rental ===");
        rental1.displayRentalDetails();
        
        // Short rental
        CarRental rental2 = new CarRental("John Smith", "Compact Car", 2);
        System.out.println("\n=== Short Rental ===");
        rental2.displayRentalDetails();
        
        // Medium rental with discount
        CarRental rental3 = new CarRental("Alice Johnson", "SUV", 5);
        System.out.println("\n=== Medium Rental (5% Discount) ===");
        rental3.displayRentalDetails();
        
        // Long rental with higher discount
        CarRental rental4 = new CarRental("Bob Wilson", "Luxury Car", 10);
        System.out.println("\n=== Long Rental (10% Discount) ===");
        rental4.displayRentalDetails();
    }
}