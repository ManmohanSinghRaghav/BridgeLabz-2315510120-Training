import java.util.ArrayList;
import java.util.List;

// Book class - can exist independently
class Book {
    private String title;
    private String author;
    private final String isbn; // final variable
    private boolean isAvailable;
    private static int totalBooks = 0;
    
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.isAvailable = true;
        totalBooks++;
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
    
    // Display book details
    public void displayBookDetails() {
        System.out.println("Title: " + title + ", Author: " + author + 
                          ", ISBN: " + isbn + ", Available: " + isAvailable);
    }
    
    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public boolean isAvailable() { return isAvailable; }
    public static int getTotalBooks() { return totalBooks; }
}

// Library class - Aggregation with Books
class Library {
    private String libraryName;
    private List<Book> books; // Aggregation - books can exist without library
    private static int totalLibraries = 0;
    
    public Library(String libraryName) {
        this.libraryName = libraryName;
        this.books = new ArrayList<>();
        totalLibraries++;
    }
    
    // Method to add book to library (Aggregation)
    public void addBook(Book book) {
        if (book != null && !books.contains(book)) {
            books.add(book);
            System.out.println("Book '" + book.getTitle() + "' added to " + libraryName);
        }
    }
    
    // Method to remove book from library
    public boolean removeBook(Book book) {
        if (books.remove(book)) {
            System.out.println("Book '" + book.getTitle() + "' removed from " + libraryName);
            return true;
        } else {
            System.out.println("Book not found in " + libraryName);
            return false;
        }
    }
    
    // Method to search for book by title
    public Book searchBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    // Method to display all books
    public void displayAllBooks() {
        System.out.println("=== " + libraryName + " Book Collection ===");
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            for (Book book : books) {
                book.displayBookDetails();
            }
        }
        System.out.println("Total books: " + books.size());
    }
    
    // Method to display available books
    public void displayAvailableBooks() {
        System.out.println("=== Available Books in " + libraryName + " ===");
        boolean hasAvailable = false;
        for (Book book : books) {
            if (book.isAvailable()) {
                book.displayBookDetails();
                hasAvailable = true;
            }
        }
        if (!hasAvailable) {
            System.out.println("No books currently available.");
        }
    }
    
    // Communication method - borrow book from library
    public boolean borrowBookFromLibrary(String title) {
        Book book = searchBook(title);
        if (book != null) {
            return book.borrowBook();
        } else {
            System.out.println("Book '" + title + "' not found in " + libraryName);
            return false;
        }
    }
    
    // Communication method - return book to library
    public void returnBookToLibrary(String title) {
        Book book = searchBook(title);
        if (book != null) {
            book.returnBook();
        } else {
            System.out.println("Book '" + title + "' not found in " + libraryName);
        }
    }
    
    // Static method with instanceof check
    public static void displayLibraryInfo(Object obj) {
        if (obj instanceof Library) {
            Library library = (Library) obj;
            System.out.println("=== Library Information ===");
            System.out.println("Name: " + library.libraryName);
            System.out.println("Total Books: " + library.books.size());
            System.out.println("Total Libraries: " + totalLibraries);
        } else {
            System.out.println("Error: Object is not a Library instance!");
        }
    }
    
    // Getters
    public String getLibraryName() { return libraryName; }
    public List<Book> getBooks() { return new ArrayList<>(books); }
    public static int getTotalLibraries() { return totalLibraries; }
    
    public static void main(String[] args) {
        // Create books (they exist independently)
        Book book1 = new Book("Java Programming", "Oracle Press", "978-0134685991");
        Book book2 = new Book("Data Structures", "MIT Press", "978-0262033848");
        Book book3 = new Book("Algorithms", "Stanford Press", "978-0321573513");
        Book book4 = new Book("Python Basics", "Python Foundation", "978-1234567890");
        
        // Create libraries
        Library centralLibrary = new Library("Central Library");
        Library universityLibrary = new Library("University Library");
        
        // Demonstrate Aggregation - same book can be in multiple libraries
        System.out.println("=== Adding Books to Libraries ===");
        centralLibrary.addBook(book1);
        centralLibrary.addBook(book2);
        centralLibrary.addBook(book3);
        
        universityLibrary.addBook(book1); // Same book in different library
        universityLibrary.addBook(book4);
        
        // Display library collections
        centralLibrary.displayAllBooks();
        System.out.println();
        universityLibrary.displayAllBooks();
        
        // Demonstrate communication between objects
        System.out.println("\n=== Library Operations ===");
        centralLibrary.borrowBookFromLibrary("Java Programming");
        centralLibrary.displayAvailableBooks();
        
        centralLibrary.returnBookToLibrary("Java Programming");
        centralLibrary.displayAvailableBooks();
        
        // Show aggregation - book exists even if removed from library
        System.out.println("\n=== Demonstrating Aggregation ===");
        centralLibrary.removeBook(book1);
        System.out.println("Book still exists independently:");
        book1.displayBookDetails();
        
        // Test instanceof
        System.out.println("\n=== Testing instanceof ===");
        Library.displayLibraryInfo(centralLibrary);
        Library.displayLibraryInfo("Not a library");
        
        System.out.println("\nTotal Books Created: " + Book.getTotalBooks());
        System.out.println("Total Libraries Created: " + Library.getTotalLibraries());
    }
}
