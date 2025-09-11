
class Book {
    // Attributes
    String title;
    String author;
    double price;
    
    // Constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }
    
    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Book Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }
    
    public static void main(String[] args) {
        Book book1 = new Book("Java Programming", "John Smith", 45.99);
        book1.displayBookDetails();
        
        System.out.println("\n--- Another Book ---");
        Book book2 = new Book("Data Structures", "Jane Doe", 52.50);
        book2.displayBookDetails();
    }
}