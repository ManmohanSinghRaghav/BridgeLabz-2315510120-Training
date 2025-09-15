class BookLibrary {
    public String ISBN;           // Public access
    protected String title;       // Protected access
    private String author;        // Private access
    
    // Constructor
    public BookLibrary(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }
    
    // Public methods to access and modify private author
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) {
            this.author = author;
        } else {
            System.out.println("Author name cannot be empty");
        }
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
    
    public static void main(String[] args) {
        System.out.println("=== Book Library System ===");
        
        BookLibrary book = new BookLibrary("978-0134685991", "Effective Java", "Joshua Bloch");
        book.displayBookDetails();
        
        System.out.println("\n--- Accessing Public Member ---");
        System.out.println("ISBN (direct access): " + book.ISBN);
        
        System.out.println("\n--- Modifying Author using public method ---");
        book.setAuthor("Joshua Bloch (Updated)");
        System.out.println("Updated Author: " + book.getAuthor());
        
        System.out.println("\n--- Testing Invalid Author ---");
        book.setAuthor(""); // Invalid author
        System.out.println("Author after invalid input: " + book.getAuthor());
    }
}

// Subclass to demonstrate access modifiers
class EBook extends BookLibrary {
    private double fileSize; // in MB
    private String format;
    
    public EBook(String ISBN, String title, String author, double fileSize, String format) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
        this.format = format;
    }
    
    public void displayEBookDetails() {
        System.out.println("=== E-Book Details ===");
        System.out.println("ISBN: " + ISBN);          // Public - accessible
        System.out.println("Title: " + title);        // Protected - accessible in subclass
        System.out.println("Author: " + getAuthor()); // Private - accessed via public method
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Format: " + format);
    }
    
    public double getFileSize() {
        return fileSize;
    }
    
    public String getFormat() {
        return format;
    }
}