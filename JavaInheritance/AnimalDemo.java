package JavaInheritance;

abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() { return name; }
    public int getAge() { return age; }

    public abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name, int age) { super(name, age); }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Dog says: Woof!");
    }
}

class Cat extends Animal {
    public Cat(String name, int age) { super(name, age); }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Cat says: Meow!");
    }
}

class Bird extends Animal {
    public Bird(String name, int age) { super(name, age); }

    @Override
    public void makeSound() {
        System.out.println(getName() + " the Bird says: Tweet!");
    }
}

public class AnimalDemo {
    public static void main(String[] args) {
        Animal[] animals = new Animal[] {
            new Dog("Rex", 5),
            new Cat("Whiskers", 3),
            new Bird("Tweety", 1)
        };

        for (Animal a : animals) {
            a.makeSound();
        }
    }
}
