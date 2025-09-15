

class BookWithConstructors {
    private String title;
    private String author;
    private double price;
    
    // Default constructor
    public BookWithConstructors() {
        this.title = "Unknown Title";
        this.author = "Unknown Author";
        this.price = 0.0;
    }
    
    // Parameterized constructor
    public BookWithConstructors(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Getter methods
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public double getPrice() {
        return price;
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    
    public static void main(String[] args) {
        // Using default constructor
        BookWithConstructors book1 = new BookWithConstructors();
        System.out.println("=== Book with Default Constructor ===");
        book1.displayBookDetails();
        
        // Using parameterized constructor
        BookWithConstructors book2 = new BookWithConstructors("Java Programming", "James Gosling", 59.99);
        System.out.println("\n=== Book with Parameterized Constructor ===");
        book2.displayBookDetails();
    }
}