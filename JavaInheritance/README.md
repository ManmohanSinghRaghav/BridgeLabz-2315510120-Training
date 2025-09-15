JavaInheritance exercises

This folder contains small Java programs demonstrating different inheritance types:

- AnimalDemo.java: Animal superclass + Dog, Cat, Bird subclasses (polymorphism via makeSound()).
- EmployeeDemo.java: Employee hierarchy with Manager, Developer, Intern overriding displayDetails().
- VehicleDemo.java: Vehicle superclass with Car, Truck, Motorcycle and polymorphic displayInfo().
- SingleInheritanceDemos.java: Book/Author and Device/Thermostat simple single inheritance examples.
- MultilevelAndHierarchicalDemos.java: Order -> ShippedOrder -> DeliveredOrder (multilevel) and Person -> Teacher/Student/Staff (hierarchical).
- HybridDemos.java: Examples using interfaces Worker and Refuelable to simulate hybrid inheritance.

How to compile and run (Windows PowerShell):

# Compile all
javac *.java

# Run a demo, for example:
java AnimalDemo

Notes:
- These files use default package to keep the examples simple and easy to run together.
- In production code, prefer explicit packages.
