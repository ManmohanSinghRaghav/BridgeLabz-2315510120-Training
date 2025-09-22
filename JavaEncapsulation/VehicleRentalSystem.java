package JavaEncapsulation;
import java.util.*;

// Abstract class Vehicle
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    
    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }
    
    // Getters and Setters
    public String getVehicleNumber() { return vehicleNumber; }
    public void setVehicleNumber(String vehicleNumber) { this.vehicleNumber = vehicleNumber; }
    
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    
    public double getRentalRate() { return rentalRate; }
    public void setRentalRate(double rentalRate) { 
        if (rentalRate > 0) this.rentalRate = rentalRate; 
    }
    
    public abstract double calculateRentalCost(int days);
}

// Interface Insurable
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Car class
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    
    public Car(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = "CAR-" + vehicleNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.1; // 10% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + insurancePolicyNumber;
    }
}

// Bike class
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    
    public Bike(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = "BIKE-" + vehicleNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; // 20% discount for bikes
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + insurancePolicyNumber;
    }
}

// Truck class
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;
    
    public Truck(String vehicleNumber, double rentalRate) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = "TRUCK-" + vehicleNumber;
    }
    
    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 1.5; // 50% premium for trucks
    }
    
    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate
    }
    
    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + insurancePolicyNumber;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR001", 100));
        vehicles.add(new Bike("BIKE001", 50));
        vehicles.add(new Truck("TRUCK001", 200));
        
        int rentalDays = 5;
        
        for (Vehicle vehicle : vehicles) {
            System.out.println("Vehicle: " + vehicle.getType() + " (" + vehicle.getVehicleNumber() + ")");
            System.out.println("Rental Cost for " + rentalDays + " days: $" + vehicle.calculateRentalCost(rentalDays));
            
            if (vehicle instanceof Insurable) {
                Insurable insurableVehicle = (Insurable) vehicle;
                System.out.println("Insurance Cost: $" + insurableVehicle.calculateInsurance());
                System.out.println("Insurance Details: " + insurableVehicle.getInsuranceDetails());
            }
            System.out.println("---");
        }
    }
}
