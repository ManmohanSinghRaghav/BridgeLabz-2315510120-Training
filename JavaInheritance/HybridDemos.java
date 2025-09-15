package JavaInheritance;

interface Worker {
    void performDuties();
}

class PersonBase {
    private String name;
    private int id;

    public PersonBase(String name, int id) { this.name = name; this.id = id; }

    public void display() { System.out.println("Person[name=" + name + ", id=" + id + "]"); }
}

class Chef extends PersonBase implements Worker {
    public Chef(String name, int id) { super(name, id); }

    @Override
    public void performDuties() { System.out.println("Chef is cooking."); }
}

class Waiter extends PersonBase implements Worker {
    public Waiter(String name, int id) { super(name, id); }

    @Override
    public void performDuties() { System.out.println("Waiter is serving."); }
}

interface Refuelable { void refuel(); }

class VehicleBase {
    private int maxSpeed; private String model;
    public VehicleBase(int maxSpeed, String model) { this.maxSpeed = maxSpeed; this.model = model; }

    @Override
    public String toString() {
        return "Vehicle[model=" + model + ", maxSpeed=" + maxSpeed + "]";
    }
}

class ElectricVehicle extends VehicleBase {
    public ElectricVehicle(int maxSpeed, String model) { super(maxSpeed, model); }
    public void charge() { System.out.println("Charging electric vehicle."); }
}

class PetrolVehicle extends VehicleBase implements Refuelable {
    public PetrolVehicle(int maxSpeed, String model) { super(maxSpeed, model); }

    @Override
    public void refuel() { System.out.println("Refuelling petrol vehicle."); }
}

public class HybridDemos {
    public static void main(String[] args) {
        Worker[] workers = new Worker[] { new Chef("Gordon", 101), new Waiter("Sam", 102) };
        for (Worker w : workers) w.performDuties();

    ElectricVehicle ev = new ElectricVehicle(160, "E-Model");
    ev.charge();
    System.out.println(ev);
    PetrolVehicle pv = new PetrolVehicle(180, "P-Model");
    pv.refuel();
    System.out.println(pv);
    }
}
