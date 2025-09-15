class Book {
    // Static variables shared across all books
    private static String libraryName = "Central Library";
    private static int totalBooks = 0;
    
    // Instance variables
    private String title;
    private String author;
    private final String isbn; // Final - cannot be changed once assigned
    private boolean isAvailable;
    
    // Constructor using 'this' to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title; // 'this' resolves parameter/field ambiguity
        this.author = author;
        this.isbn = isbn; // Final variable initialization
        this.isAvailable = true;
        totalBooks++; // Increment total books count
    }
    
    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library: " + libraryName);
    }
    
    // Static method to get total books
    public static int getTotalBooks() {
        return totalBooks;
    }
    
    // Static method to set library name
    public static void setLibraryName(String libraryName) {
        Book.libraryName = libraryName;
    }
    
    // Method to borrow book
    public boolean borrowBook() {
        if (this.isAvailable) {
            this.isAvailable = false;
            System.out.println("Book '" + this.title + "' borrowed successfully.");
            return true;
        } else {
            System.out.println("Book '" + this.title + "' is not available.");
            return false;
        }
    }
    
    // Method to return book
    public void returnBook() {
        if (!this.isAvailable) {
            this.isAvailable = true;
            System.out.println("Book '" + this.title + "' returned successfully.");
        } else {
            System.out.println("Book '" + this.title + "' was not borrowed.");
        }
    }
    
    // Static method to display book details with instanceof check
    public static void displayBookDetails(Object obj) {
        if (obj instanceof Book) { // Type checking with instanceof
            Book book = (Book) obj; // Safe casting
            System.out.println("=== Book Details ===");
            System.out.println("Library: " + libraryName);
            System.out.println("Title: " + book.title);
            System.out.println("Author: " + book.author);
            System.out.println("ISBN: " + book.isbn);
            System.out.println("Available: " + (book.isAvailable ? "Yes" : "No"));
        } else {
            System.out.println("Error: Object is not a Book instance!");
        }
    }
    
    // Getters
    public String getTitle() {
        return this.title;
    }
    
    public String getAuthor() {
        return this.author;
    }
    
    public String getIsbn() {
        return this.isbn; // Final variable can be read
    }
    
    public boolean isAvailable() {
        return this.isAvailable;
    }
    
    public static void main(String[] args) {
        System.out.println("=== Library Management System ===");
        Book.displayLibraryName();
        System.out.println("Initial Total Books: " + Book.getTotalBooks());
        
        // Creating books
        Book book1 = new Book("Java Programming", "Oracle Press", "978-0134685991");
        Book book2 = new Book("Data Structures", "MIT Press", "978-0262033848");
        Book book3 = new Book("Algorithms", "Stanford Press", "978-0321573513");
        
        System.out.println("\nTotal Books after creation: " + Book.getTotalBooks());
        
        // Using instanceof to safely display book details
        Book.displayBookDetails(book1);
        
        System.out.println("\n--- Library Operations ---");
        book1.borrowBook();
        Book.displayBookDetails(book1);
        
        book1.returnBook();
        Book.displayBookDetails(book1);
        
        // Testing instanceof with non-Book object
        String notABook = "This is not a book";
        System.out.println("\n--- Testing instanceof with invalid object ---");
        Book.displayBookDetails(notABook);
        
        // Final variable demonstration
        System.out.println("\n--- Final Variable Demonstration ---");
        System.out.println("Book ISBN (final): " + book1.getIsbn());
        // book1.isbn = "NEW-ISBN"; // This would cause compilation error
        
        // Static variable change affects all books
        System.out.println("\n--- Changing Library Name ---");
        Book.setLibraryName("University Library");
        Book.displayBookDetails(book2);
        Book.displayBookDetails(book3);
    }
}
