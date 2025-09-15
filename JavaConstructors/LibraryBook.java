

class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean availability;
    
    // Default constructor
    public LibraryBook() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
        this.availability = true;
    }
    
    // Parameterized constructor
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = true; // New books are available by default
    }
    
    // Method to borrow a book
    public boolean borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book '" + title + "' has been borrowed successfully.");
            return true;
        } else {
            System.out.println("Sorry, book '" + title + "' is not available for borrowing.");
            return false;
        }
    }
    
    // Method to return a book
    public void returnBook() {
        if (!availability) {
            availability = true;
            System.out.println("Book '" + title + "' has been returned successfully.");
        } else {
            System.out.println("Book '" + title + "' was not borrowed.");
        }
    }
    
    // Getters
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getPrice() {
        return price;
    }
    
    public boolean isAvailable() {
        return availability;
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
    }
    
    public static void main(String[] args) {
        // Creating books
        LibraryBook book1 = new LibraryBook("Java Programming", "Oracle", 45.99);
        LibraryBook book2 = new LibraryBook("Python Basics", "Python Foundation", 35.50);
        
        System.out.println("=== Library Book System ===");
        book1.displayBookDetails();
        
        System.out.println("\n--- Borrowing Book ---");
        book1.borrowBook();
        book1.displayBookDetails();
        
        System.out.println("\n--- Trying to Borrow Same Book Again ---");
        book1.borrowBook();
        
        System.out.println("\n--- Returning Book ---");
        book1.returnBook();
        book1.displayBookDetails();
        
        System.out.println("\n--- Another Book ---");
        book2.displayBookDetails();
        book2.borrowBook();
        book2.displayBookDetails();
    }
}