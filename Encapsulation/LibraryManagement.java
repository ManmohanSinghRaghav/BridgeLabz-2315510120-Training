import java.util.*;

// Abstract class LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;
    private boolean isAvailable;
    
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    
    // Getters and Setters
    public String getItemId() { return itemId; }
    public void setItemId(String itemId) { this.itemId = itemId; }
    
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    
    public boolean isAvailable() { return isAvailable; }
    protected void setAvailable(boolean available) { this.isAvailable = available; }
    
    // Abstract method
    public abstract int getLoanDuration();
    
    // Concrete method
    public String getItemDetails() {
        return "ID: " + itemId + ", Title: " + title + ", Author: " + author + 
               ", Available: " + isAvailable + ", Loan Duration: " + getLoanDuration() + " days";
    }
}

// Interface Reservable
interface Reservable {
    boolean reserveItem();
    boolean checkAvailability();
}

// Book class
class Book extends LibraryItem implements Reservable {
    private String reservedBy;
    
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }
    
    @Override
    public boolean reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            this.reservedBy = "Reserved";
            System.out.println("Book reserved successfully");
            return true;
        }
        System.out.println("Book is not available for reservation");
        return false;
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// Magazine class
class Magazine extends LibraryItem implements Reservable {
    private String reservedBy;
    
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }
    
    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
    
    @Override
    public boolean reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            this.reservedBy = "Reserved";
            System.out.println("Magazine reserved successfully");
            return true;
        }
        System.out.println("Magazine is not available for reservation");
        return false;
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

// DVD class
class DVD extends LibraryItem implements Reservable {
    private String reservedBy;
    
    public DVD(String itemId, String title, String director) {
        super(itemId, title, director);
    }
    
    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
    
    @Override
    public boolean reserveItem() {
        if (isAvailable()) {
            setAvailable(false);
            this.reservedBy = "Reserved";
            System.out.println("DVD reserved successfully");
            return true;
        }
        System.out.println("DVD is not available for reservation");
        return false;
    }
    
    @Override
    public boolean checkAvailability() {
        return isAvailable();
    }
}

public class LibraryManagement {
    public static void manageLibraryItems(List<LibraryItem> items) {
        for (LibraryItem item : items) {
            System.out.println(item.getItemDetails());
            
            if (item instanceof Reservable) {
                Reservable reservableItem = (Reservable) item;
                if (reservableItem.checkAvailability()) {
                    reservableItem.reserveItem();
                }
            }
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();
        items.add(new Book("B001", "Java Programming", "Author A"));
        items.add(new Magazine("M001", "Tech Today", "Editor B"));
        items.add(new DVD("D001", "Programming Tutorial", "Director C"));
        
        manageLibraryItems(items);
    }
}
