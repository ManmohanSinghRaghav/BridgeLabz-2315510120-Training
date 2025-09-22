import java.util.*;

public class LibraryRecord {
    public static void main(String[] args) {
        LibraryItem book = new Book("01", "Champak", "Manmohan");
        LibraryItem magazine = new Magazine("01", "Hindustan Times", "Sevi");
        LibraryItem dvd = new DvD("01", "", "Christopher Nolan");

        book.getItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");

        magazine.getItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");

        dvd.getItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
    }

    static abstract class LibraryItem {
        private String itemId;
        private String title;
        private String author;

        LibraryItem(String itemId, String title, String author) {
            this.itemId = itemId;
            this.title = title;
            this.author = author;
        }

        abstract int getLoanDuration();

        void getItemDetails() {
            System.out.println("ID : " + itemId);
            System.out.println("Title : " + title);
            System.out.println("Author: " + author);
        }
    }

    static class Book extends LibraryItem {
        Book(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        int getLoanDuration() {
            return 14;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        int getLoanDuration() {
            return 7;
        }
    }

    static class DvD extends LibraryItem {
        DvD(String itemId, String title, String author) {
            super(itemId, title, author);
        }

        int getLoanDuration() {
            return 3;
        }
    }

    interface Reservable {
        HashMap<String, LibraryItem> libraryList = new HashMap<>();

        void reserveItem(String itemId, String borrowerName);

        boolean checkAvailability(String itemId);
    }

    static class Library implements Reservable {
        private HashMap<String, String> reservations = new HashMap<>();

        public void reserveItem(String itemId, String borrowerName) {
            if (!reservations.containsKey(itemId)) {
                reservations.put(itemId, borrowerName);
                System.out.println("Item " + itemId + " reserved for " + borrowerName);
            } else {
                System.out.println("Item " + itemId + " is already reserved.");
            }
        }

        public boolean checkAvailability(String itemId) {
            return !reservations.containsKey(itemId);
        }
    }
}