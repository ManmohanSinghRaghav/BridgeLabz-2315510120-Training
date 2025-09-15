class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;
    
    // Class variable (static) - fixed for all vehicles
    private static double registrationFee = 150.00;
    
    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }
    
    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }
    
    // Class method (static) to update registration fee
    public static void updateRegistrationFee(double newFee) {
        if (newFee > 0) {
            registrationFee = newFee;
            System.out.println("Registration fee updated to: $" + registrationFee);
        } else {
            System.out.println("Invalid registration fee. Fee must be positive.");
        }
    }
    
    // Getters
    public String getOwnerName() {
        return ownerName;
    }
    
    public String getVehicleType() {
        return vehicleType;
    }
    
    public static double getRegistrationFee() {
        return registrationFee;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Vehicle Registration System ===");
        
        // Creating vehicles
        Vehicle vehicle1 = new Vehicle("John Smith", "Car");
        Vehicle vehicle2 = new Vehicle("Alice Johnson", "Motorcycle");
        Vehicle vehicle3 = new Vehicle("Bob Wilson", "Truck");
        
        System.out.println("--- Initial Vehicle Details ---");
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
        System.out.println();
        vehicle3.displayVehicleDetails();
        
        System.out.println("\n--- Updating Registration Fee ---");
        Vehicle.updateRegistrationFee(200.00);
        
        System.out.println("\n--- Vehicle Details After Fee Update ---");
        vehicle1.displayVehicleDetails();
        System.out.println();
        vehicle2.displayVehicleDetails();
        System.out.println();
        vehicle3.displayVehicleDetails();
        
        System.out.println("\n--- Testing Invalid Fee Update ---");
        Vehicle.updateRegistrationFee(-50.00);
        
        System.out.println("\n--- Current Registration Fee ---");
        System.out.println("Registration Fee: $" + Vehicle.getRegistrationFee());
    }
}