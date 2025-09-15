

class HotelBooking {
    private String guestName;
    private String roomType;
    private int nights;
    private double pricePerNight;
    
    // Default constructor
    public HotelBooking() {
        this.guestName = "Guest";
        this.roomType = "Standard";
        this.nights = 1;
        this.pricePerNight = calculatePricePerNight();
    }
    
    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights > 0 ? nights : 1;
        this.pricePerNight = calculatePricePerNight();
    }
    
    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
        this.pricePerNight = other.pricePerNight;
    }
    
    // Private method to calculate price per night based on room type
    private double calculatePricePerNight() {
        switch (roomType.toLowerCase()) {
            case "standard":
                return 100.0;
            case "deluxe":
                return 150.0;
            case "suite":
                return 250.0;
            default:
                return 100.0;
        }
    }
    
    // Method to calculate total cost
    public double calculateTotalCost() {
        return nights * pricePerNight;
    }
    
    // Getters
    public String getGuestName() {
        return guestName;
    }
    
    public String getRoomType() {
        return roomType;
    }
    
    public int getNights() {
        return nights;
    }
    
    public double getPricePerNight() {
        return pricePerNight;
    }
    
    // Method to display booking details
    public void displayBookingDetails() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Number of Nights: " + nights);
        System.out.println("Price per Night: $" + pricePerNight);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }
    
    public static void main(String[] args) {
        // Using default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("=== Default Booking ===");
        booking1.displayBookingDetails();
        
        // Using parameterized constructor
        HotelBooking booking2 = new HotelBooking("Alice Johnson", "Deluxe", 3);
        System.out.println("\n=== Parameterized Booking ===");
        booking2.displayBookingDetails();
        
        // Using copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("\n=== Copied Booking ===");
        booking3.displayBookingDetails();
        
        // Suite booking
        HotelBooking booking4 = new HotelBooking("Bob Smith", "Suite", 2);
        System.out.println("\n=== Suite Booking ===");
        booking4.displayBookingDetails();
    }
}