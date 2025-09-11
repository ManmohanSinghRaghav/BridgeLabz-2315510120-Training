

class MovieTicket {
    // Attributes
    String movieName;
    String seatNumber;
    double price;
    boolean isBooked;
    
    // Constructor
    public MovieTicket(String movieName) {
        this.movieName = movieName;
        this.seatNumber = "";
        this.price = 0.0;
        this.isBooked = false;
    }
    
    // Method to book a ticket
    public void bookTicket(String seatNumber, double price) {
        if (!isBooked) {
            this.seatNumber = seatNumber;
            this.price = price;
            this.isBooked = true;
            System.out.println("Ticket booked successfully!");
        } else {
            System.out.println("Ticket is already booked!");
        }
    }
    
    // Method to display ticket details
    public void displayTicketDetails() {
        System.out.println("=== Movie Ticket Details ===");
        System.out.println("Movie Name: " + movieName);
        if (isBooked) {
            System.out.println("Seat Number: " + seatNumber);
            System.out.println("Price: $" + price);
            System.out.println("Status: Booked");
        } else {
            System.out.println("Status: Not Booked");
        }
    }
    
    public static void main(String[] args) {
        MovieTicket ticket1 = new MovieTicket("Avengers: Endgame");
        ticket1.displayTicketDetails();
        
        System.out.println("\n--- Booking Ticket ---");
        ticket1.bookTicket("A12", 15.99);
        ticket1.displayTicketDetails();
        
        System.out.println("\n--- Another Movie Ticket ---");
        MovieTicket ticket2 = new MovieTicket("Spider-Man");
        ticket2.bookTicket("B08", 12.50);
        ticket2.displayTicketDetails();
        
        System.out.println("\n--- Trying to book same ticket again ---");
        ticket1.bookTicket("C15", 20.00);
    }
}