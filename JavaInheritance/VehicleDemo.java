package JavaInheritance;

class Vehicle {
    private int maxSpeed;
    private String fuelType;

    public Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }

    public int getMaxSpeed() { return maxSpeed; }
    public String getFuelType() { return fuelType; }

    public void displayInfo() {
        System.out.println("Vehicle[maxSpeed=" + maxSpeed + ", fuelType=" + fuelType + "]");
    }
}

class Car extends Vehicle {
    private int seatCapacity;

    public Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Car, seats=" + seatCapacity);
    }
}

class Truck extends Vehicle {
    private double loadCapacity;

    public Truck(int maxSpeed, String fuelType, double loadCapacity) {
        super(maxSpeed, fuelType);
        this.loadCapacity = loadCapacity;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Truck, loadCapacity=" + loadCapacity);
    }
}

class Motorcycle extends Vehicle {
    private boolean hasCarrier;

    public Motorcycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed, fuelType);
        this.hasCarrier = hasCarrier;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Type: Motorcycle, hasCarrier=" + hasCarrier);
    }
}

public class VehicleDemo {
    public static void main(String[] args) {
        Vehicle[] fleet = new Vehicle[] {
            new Car(180, "Petrol", 5),
            new Truck(120, "Diesel", 2000.5),
            new Motorcycle(160, "Petrol", false)
        };

        for (Vehicle v : fleet) {
            v.displayInfo();
            System.out.println();
        }
    }
}
