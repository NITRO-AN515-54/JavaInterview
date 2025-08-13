/*

Design a application having this attribute

Person
    Driver
    Manager

Attribute
    Name
    Age
    Dob
    Address

-doeat
-dosleep
-dowork


Class Test {
    public static void main(String[] args)
    {

    }
}

 */

package CoreConcept;

// Interface for behaviors
interface Workable {
    void doEat();
    void doSleep();
    void doWork();
}

// Base class for attributes
class Person {
    String name;
    int age;
    String dob;
    String address;

    public Person(String name, int age, String dob, String address) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.address = address;
    }
}

// Driver implements behavior
class Driver extends Person implements Workable {
    public Driver(String name, int age, String dob, String address) {
        super(name, age, dob, address);
    }

    @Override
    public void doEat() {
        System.out.println(name + " is eating a meal before driving.");
    }

    @Override
    public void doSleep() {
        System.out.println(name + " is sleeping after a long drive.");
    }

    @Override
    public void doWork() {
        System.out.println(name + " is driving a truck.");
    }
}

// Manager implements behavior
class Manager extends Person implements Workable {
    public Manager(String name, int age, String dob, String address) {
        super(name, age, dob, address);
    }

    @Override
    public void doEat() {
        System.out.println(name + " is having lunch at the office.");
    }

    @Override
    public void doSleep() {
        System.out.println(name + " is sleeping after work.");
    }

    @Override
    public void doWork() {
        System.out.println(name + " is managing the team.");
    }
}

public class ClassWithAttributes {
    public static void main(String[] args) {
        Workable driver = new Driver("John", 35, "1989-05-12", "New York");
        Workable manager = new Manager("Alice", 40, "1985-02-20", "Los Angeles");

        driver.doEat();
        driver.doSleep();
        driver.doWork();

        System.out.println();

        manager.doEat();
        manager.doSleep();
        manager.doWork();
    }
}
