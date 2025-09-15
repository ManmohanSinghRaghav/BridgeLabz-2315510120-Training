package JavaInheritance;

class Employee {
    private String name;
    private int id;
    private double salary;

    public Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() { return name; }
    public int getId() { return id; }
    public double getSalary() { return salary; }

    public void displayDetails() {
        System.out.println("Employee[id=" + id + ", name=" + name + ", salary=" + salary + "]");
    }
}

class Manager extends Employee {
    private int teamSize;

    public Manager(String name, int id, double salary, int teamSize) {
        super(name, id, salary);
        this.teamSize = teamSize;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Manager, teamSize=" + teamSize);
    }
}

class Developer extends Employee {
    private String programmingLanguage;

    public Developer(String name, int id, double salary, String programmingLanguage) {
        super(name, id, salary);
        this.programmingLanguage = programmingLanguage;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Developer, language=" + programmingLanguage);
    }
}

class Intern extends Employee {
    private int durationMonths;

    public Intern(String name, int id, double salary, int durationMonths) {
        super(name, id, salary);
        this.durationMonths = durationMonths;
    }

    @Override
    public void displayDetails() {
        super.displayDetails();
        System.out.println("Role: Intern, durationMonths=" + durationMonths);
    }
}

public class EmployeeDemo {
    public static void main(String[] args) {
        Employee[] employees = new Employee[] {
            new Manager("Alice", 1, 90000, 5),
            new Developer("Bob", 2, 70000, "Java"),
            new Intern("Charlie", 3, 20000, 6)
        };

        for (Employee e : employees) {
            e.displayDetails();
            System.out.println();
        }
    }
}
