

class BookWithConstructors {
    private String title;
    private String author;
    private double price;
    
    // Default constructor with constructor chaining
    public BookWithConstructors() {
        this("Unknown Title", "Unknown Author", 0.0);
    }
    
    // Parameterized constructor with validation
    public BookWithConstructors(String title, String author, double price) {
        this.title = validateTitle(title);
        this.author = validateAuthor(author);
        this.price = validatePrice(price);
    }
    
    // Copy constructor
    public BookWithConstructors(BookWithConstructors other) {
        this.title = other.title;
        this.author = other.author;
        this.price = other.price;
    }
    
    // Private validation methods (encapsulated logic)
    private String validateTitle(String title) {
        return (title != null && !title.trim().isEmpty()) ? title : "Unknown Title";
    }
    
    private String validateAuthor(String author) {
        return (author != null && !author.trim().isEmpty()) ? author : "Unknown Author";
    }
    
    private double validatePrice(double price) {
        return (price >= 0) ? price : 0.0;
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
    
    // Setter methods with validation
    public void setTitle(String title) {
        this.title = validateTitle(title);
    }
    
    public void setAuthor(String author) {
        this.author = validateAuthor(author);
    }
    
    public void setPrice(double price) {
        this.price = validatePrice(price);
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    
    public static void main(String[] args) {
        // Using default constructor (with chaining)
        BookWithConstructors book1 = new BookWithConstructors();
        System.out.println("=== Book with Default Constructor ===");
        book1.displayBookDetails();
        
        // Using parameterized constructor
        BookWithConstructors book2 = new BookWithConstructors("Java Programming", "James Gosling", 59.99);
        System.out.println("\n=== Book with Parameterized Constructor ===");
        book2.displayBookDetails();
        
        // Using copy constructor
        BookWithConstructors book3 = new BookWithConstructors(book2);
        System.out.println("\n=== Book with Copy Constructor ===");
        book3.displayBookDetails();
        
        // Testing validation
        BookWithConstructors book4 = new BookWithConstructors("", null, -10.0);
        System.out.println("\n=== Book with Invalid Data (Validated) ===");
        book4.displayBookDetails();
    }
}
