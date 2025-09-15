package JavaInheritance;

class Order {
    private String orderId;
    private String orderDate;

    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderId() { return orderId; }
    public String getOrderDate() { return orderDate; }

    public String getOrderStatus() { return "Created"; }
}

class ShippedOrder extends Order {
    private String trackingNumber;

    public ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() { return "Shipped (tracking=" + trackingNumber + ")"; }
}

class DeliveredOrder extends ShippedOrder {
    private String deliveryDate;

    public DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() { return "Delivered on " + deliveryDate; }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) { this.name = name; this.age = age; }

    public void display() { System.out.println("Person[name=" + name + ", age=" + age + "]"); }
}

class Teacher extends Person {
    private String subject;
    public Teacher(String name, int age, String subject) { super(name, age); this.subject = subject; }
    public void displayRole() { System.out.println("Teacher[subject=" + subject + "]"); }
}

class Student extends Person {
    private String grade;
    public Student(String name, int age, String grade) { super(name, age); this.grade = grade; }
    public void displayRole() { System.out.println("Student[grade=" + grade + "]"); }
}

class Staff extends Person {
    private String position;
    public Staff(String name, int age, String position) { super(name, age); this.position = position; }
    public void displayRole() { System.out.println("Staff[position=" + position + "]"); }
}

public class MultilevelAndHierarchicalDemos {
    public static void main(String[] args) {
        Order o = new Order("O1", "2025-09-15");
        System.out.println(o.getOrderStatus());

        DeliveredOrder d = new DeliveredOrder("O2", "2025-09-10", "TRK123", "2025-09-14");
        System.out.println(d.getOrderStatus());

        Teacher t = new Teacher("Mrs. Smith", 40, "Math");
        t.display(); t.displayRole();

        Student s = new Student("John", 16, "10th Grade");
        s.display(); s.displayRole();
    }
}
