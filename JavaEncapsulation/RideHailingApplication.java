package JavaEncapsulation;
import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;
    
    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = "Unknown";
    }
    
    // Getters and Setters (Encapsulation)
    public String getVehicleId() { return vehicleId; }
    protected void setVehicleId(String vehicleId) { this.vehicleId = vehicleId; }
    
    public String getDriverName() { return driverName; }
    protected void setDriverName(String driverName) { this.driverName = driverName; }
    
    public double getRatePerKm() { return ratePerKm; }
    protected void setRatePerKm(double ratePerKm) { 
        if (ratePerKm > 0) this.ratePerKm = ratePerKm; 
    }
    
    protected String getCurrentLocation() { return currentLocation; }
    protected void setCurrentLocation(String location) { this.currentLocation = location; }
    
    // Abstract method
    public abstract double calculateFare(double distance);
    
    // Concrete method
    public String getVehicleDetails() {
        return "Vehicle ID: " + vehicleId + ", Driver: " + driverName + 
               ", Rate: $" + ratePerKm + "/km, Location: " + currentLocation;
    }
}

// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Car class
class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 5.0; // Base fare of $5
    }
    
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Car location updated to: " + newLocation);
    }
}

// Bike class
class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 2.0; // Base fare of $2
    }
    
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Bike location updated to: " + newLocation);
    }
}

// Auto class
class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
    }
    
    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 3.0; // Base fare of $3
    }
    
    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }
    
    @Override
    public void updateLocation(String newLocation) {
        setCurrentLocation(newLocation);
        System.out.println("Auto location updated to: " + newLocation);
    }
}

// Ride class to manage rides
class Ride {
    private String rideId;
    private Vehicle vehicle;
    private double distance;
    private String destination;
    
    public Ride(String rideId, Vehicle vehicle, double distance, String destination) {
        this.rideId = rideId;
        this.vehicle = vehicle;
        this.distance = distance;
        this.destination = destination;
    }
    
    public double calculateTotalFare() {
        return vehicle.calculateFare(distance);
    }
    
    public void displayRideDetails() {
        System.out.println("Ride ID: " + rideId);
        System.out.println(vehicle.getVehicleDetails());
        System.out.println("Distance: " + distance + " km");
        System.out.println("Destination: " + destination);
        System.out.println("Total Fare: $" + calculateTotalFare());
        
        if (vehicle instanceof GPS) {
            GPS gpsVehicle = (GPS) vehicle;
            gpsVehicle.updateLocation(destination);
        }
    }
}

public class RideHailingApplication {
    public static void calculateFaresForVehicles(List<Vehicle> vehicles, double distance) {
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.getVehicleDetails());
            System.out.println("Fare for " + distance + " km: $" + vehicle.calculateFare(distance));
            
            if (vehicle instanceof GPS) {
                GPS gpsVehicle = (GPS) vehicle;
                gpsVehicle.updateLocation("Downtown");
            }
            System.out.println("---");
        }
    }
    
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR001", "John Doe", 2.5));
        vehicles.add(new Bike("BIKE001", "Jane Smith", 1.5));
        vehicles.add(new Auto("AUTO001", "Bob Johnson", 2.0));
        
        double tripDistance = 10.0;
        calculateFaresForVehicles(vehicles, tripDistance);
        
        // Example ride
        System.out.println("\n=== Sample Ride ===");
        Ride ride = new Ride("RIDE001", vehicles.get(0), 15.0, "Airport");
        ride.displayRideDetails();
    }
}
