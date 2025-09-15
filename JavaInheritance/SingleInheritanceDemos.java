package JavaInheritance;

class Book {
    private String title;
    private int publicationYear;

    public Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public String getTitle() { return title; }
    public int getPublicationYear() { return publicationYear; }

    public void displayInfo() {
        System.out.println("Book[title=" + title + ", year=" + publicationYear + "]");
    }
}

class Author extends Book {
    private String name;
    private String bio;

    public Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Author[name=" + name + ", bio=" + bio + "]");
    }
}

class Device {
    private String deviceId;
    private boolean status;

    public Device(String deviceId, boolean status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    public void displayStatus() {
        System.out.println("Device[id=" + deviceId + ", status=" + (status ? "ON" : "OFF") + "]");
    }
}

class Thermostat extends Device {
    private double temperatureSetting;

    public Thermostat(String deviceId, boolean status, double temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Thermostat[temperature=" + temperatureSetting + "]");
    }
}

public class SingleInheritanceDemos {
    public static void main(String[] args) {
        Author a = new Author("Design Patterns", 1994, "Erich Gamma", "Software engineer and author");
        a.displayInfo();

        Thermostat t = new Thermostat("T1000", true, 22.5);
        t.displayStatus();
    }
}
