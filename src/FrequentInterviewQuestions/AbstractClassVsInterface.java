package FrequentInterviewQuestions;

/**
 * This class demonstrates the differences between Abstract Classes and Interfaces in Java
 * 
 * Key differences:
 * 1. Methods: Abstract class can have both abstract and concrete methods, while 
 *    interfaces traditionally had only abstract methods (prior to Java 8)
 * 2. Variables: Abstract class can have instance variables, interfaces can only have constants
 * 3. Constructors: Abstract class can have constructors, interfaces cannot
 * 4. Access Modifiers: Abstract class methods can have any access modifier, interface methods are implicitly public
 * 5. Inheritance: A class can extend only one abstract class, but implement multiple interfaces
 * 6. Purpose: Abstract class for 'is-a' relationship, interface for 'can-do' relationship
 */
public class AbstractClassVsInterface {

    public static void main(String[] args) {
        System.out.println("===== Abstract Class vs Interface Demonstration =====");

        // 1. Basic Differences
        demonstrateBasicDifferences();

        // 2. Multiple Inheritance
        demonstrateMultipleInheritance();

        // 3. Evolution with Java 8+
        demonstrateJava8Features();

        // 4. When to Use Each
        demonstrateWhenToUse();

        // 5. Real-world Examples
        demonstrateRealWorldExamples();
    }

    /**
     * Demonstrates basic differences between abstract classes and interfaces
     */
    private static void demonstrateBasicDifferences() {
        System.out.println("\n1. Basic Differences:\n");

        // Creating objects from concrete implementations
        System.out.println("Creating objects from implementations:");

        // Abstract class implementation
        Animal dog = new Dog("Buddy", 3);
        dog.eat();          // Concrete method from abstract class
        dog.makeSound();    // Abstract method implemented by subclass
        System.out.println("Dog age: " + dog.getAge());  // Using instance variable

        // Interface implementation
        Flyable bird = new Bird("Sparrow");
        bird.fly();         // Abstract method from interface
        bird.land();        // Default method from interface (Java 8+)
        System.out.println("Maximum flying speed: " + Flyable.MAX_SPEED);  // Constant from interface

        System.out.println("\nKey Differences:");
        System.out.println("1. Abstract Class:");
        System.out.println("   - Can have instance variables with any access modifier");
        System.out.println("   - Can have constructors");
        System.out.println("   - Can have both abstract and concrete methods");
        System.out.println("   - Methods can have any access modifier");

        System.out.println("\n2. Interface:");
        System.out.println("   - Can only have constants (public static final)");
        System.out.println("   - Cannot have constructors");
        System.out.println("   - Originally only abstract methods, now can have default and static methods");
        System.out.println("   - Methods are implicitly public");
    }

    /**
     * Demonstrates multiple inheritance through interfaces
     */
    private static void demonstrateMultipleInheritance() {
        System.out.println("\n2. Multiple Inheritance:\n");

        // Class implementing multiple interfaces
        Duck duck = new Duck("Donald", 2);
        duck.eat();         // From Animal abstract class
        duck.makeSound();    // From Animal abstract class
        duck.fly();         // From Flyable interface
        duck.swim();        // From Swimmable interface

        System.out.println("\nA class can extend only one abstract class but implement multiple interfaces:");
        System.out.println("Duck extends Animal and implements both Flyable and Swimmable");

        // Using different interfaces with the same object
        System.out.println("\nUsing different interface references for the same object:");

        Flyable flyingDuck = duck;
        flyingDuck.fly();   // Accessing as a Flyable

        Swimmable swimmingDuck = duck;
        swimmingDuck.swim(); // Accessing as a Swimmable

        // Cannot extend multiple abstract classes
        System.out.println("\nJava does not support extending multiple abstract classes");
        System.out.println("This would cause the infamous 'diamond problem' in multiple inheritance");
    }

    /**
     * Demonstrates Java 8+ features for interfaces
     */
    private static void demonstrateJava8Features() {
        System.out.println("\n3. Evolution with Java 8+:\n");

        // Default methods in interfaces
        Flyable bird = new Bird("Eagle");
        bird.fly();         // Abstract method
        bird.land();        // Default method

        // Default methods can be overridden
        Flyable airplane = new Airplane();
        airplane.fly();
        airplane.land();    // Overridden default method

        // Static methods in interfaces
        String flyingTip = Flyable.getFlyingTip();
        System.out.println("Flying tip: " + flyingTip);  // Static method in interface

        // Private methods in interfaces (Java 9+)
        System.out.println("\nJava 9+ also introduced private methods in interfaces");
        System.out.println("This allows for better code organization and reuse within the interface");

        System.out.println("\nWith these changes, the distinction between abstract classes and");
        System.out.println("interfaces has become less clear, but fundamental differences remain:");
        System.out.println("- Interfaces still cannot have instance variables");
        System.out.println("- Interfaces still cannot have constructors");
        System.out.println("- Classes can still implement multiple interfaces but extend only one class");
    }

    /**
     * Demonstrates when to use abstract classes vs interfaces
     */
    private static void demonstrateWhenToUse() {
        System.out.println("\n4. When to Use Each:\n");

        System.out.println("Use Abstract Class when:");
        System.out.println("- You want to share code among closely related classes");
        System.out.println("- You need to declare non-static or non-final fields (instance variables)");
        System.out.println("- You want to provide a common base implementation");
        System.out.println("- You're working with an 'is-a' relationship");
        System.out.println("- Your abstract class would be the base for tightly coupled class hierarchy");
        System.out.println("Example: Animal as base for Dog, Cat, etc.");

        System.out.println("\nUse Interface when:");
        System.out.println("- You want to define a contract that unrelated classes can implement");
        System.out.println("- You want to take advantage of multiple inheritance");
        System.out.println("- You're specifying behavior but not concerned with who implements it");
        System.out.println("- You're working with a 'can-do' relationship");
        System.out.println("- You want to decouple the definition from the implementation");
        System.out.println("Example: Flyable can be implemented by Bird, Airplane, etc.");

        System.out.println("\nDemo Examples:");
        System.out.println("- AbstractVehicle class: Base for closely related Car, Motorcycle classes");
        Car car = new SportsCar();
        car.startEngine();  // Common implementation from abstract class
        car.accelerate();   // Specialized implementation
        car.applyBrakes();  // Specialized implementation

        System.out.println("\n- Drivable interface: Implemented by unrelated Vehicle, Simulator classes");
        Drivable carDriver = new Car();  // Vehicle implementation
        Drivable simulator = new DrivingSimulator();  // Non-vehicle implementation
        carDriver.drive();  // Same contract, different implementation
        simulator.drive();  // Same contract, different implementation
    }

    /**
     * Demonstrates real-world examples of abstract classes and interfaces
     */
    private static void demonstrateRealWorldExamples() {
        System.out.println("\n5. Real-world Examples:\n");

        System.out.println("Examples from Java Standard Library:");

        System.out.println("Abstract Classes:");
        System.out.println("- java.io.InputStream, java.io.OutputStream, java.io.Reader, java.io.Writer");
        System.out.println("  Common functionality for I/O operations with some abstract methods");
        System.out.println("- java.util.AbstractList, java.util.AbstractSet, java.util.AbstractMap");
        System.out.println("  Provide default implementations for collection interfaces");

        System.out.println("\nInterfaces:");
        System.out.println("- java.lang.Comparable, java.util.Comparator");
        System.out.println("  Define how objects should be compared, implemented by many unrelated classes");
        System.out.println("- java.lang.Runnable, java.util.concurrent.Callable");
        System.out.println("  Define task execution contracts for multithreading");
        System.out.println("- java.util.List, java.util.Set, java.util.Map");
        System.out.println("  Define contracts for different types of collections");

        // Demo with two different logger implementations
        System.out.println("\nExample with Logger implementations:");

        Logger consoleLogger = new ConsoleLogger();
        Logger fileLogger = new FileLogger("app.log");

        // Both implement the same interface but work differently
        consoleLogger.log("This is a console message");
        fileLogger.log("This is a file message");

        // Both inherit common functionality from AbstractLogger
        consoleLogger.logError("Console error");  // Uses template method from abstract class
        fileLogger.logError("File error");        // Uses template method from abstract class
    }
}

// Abstract Class Example
abstract class Animal {
    // Instance variables - allowed in abstract classes
    private String name;
    private int age;

    // Constructor - allowed in abstract classes
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Getters for instance variables
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    // Concrete method with implementation
    public void eat() {
        System.out.println(name + " is eating");
    }

    // Abstract method without implementation
    public abstract void makeSound();
}

// Interface Example
interface Flyable {
    // Constant (implicitly public static final)
    int MAX_SPEED = 100;  // mph

    // Abstract method (implicitly public abstract)
    void fly();

    // Default method with implementation (Java 8+)
    default void land() {
        System.out.println("Landing normally");
    }

    // Static method (Java 8+)
    static String getFlyingTip() {
        return "Maintain proper altitude for safety";
    }

    // Private method (Java 9+) - uncomment if using Java 9 or higher
    // private void helperMethod() {
    //     System.out.println("Helper method for internal use only");
    // }
}

// Another interface for multiple inheritance demo
interface Swimmable {
    void swim();
}

// Concrete implementation of abstract class
class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);  // Calling abstract class constructor
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Woof!");
    }
}

// Concrete implementation of interface
class Bird implements Flyable {
    private String species;

    public Bird(String species) {
        this.species = species;
    }

    @Override
    public void fly() {
        System.out.println(species + " is flying");
    }
}

// Concrete implementation overriding default method
class Airplane implements Flyable {
    @Override
    public void fly() {
        System.out.println("Airplane is flying with engines");
    }

    @Override
    public void land() {
        System.out.println("Airplane is landing on runway");  // Overriding default method
    }
}

// Class implementing multiple interfaces and extending abstract class
class Duck extends Animal implements Flyable, Swimmable {
    public Duck(String name, int age) {
        super(name, age);
    }

    @Override
    public void makeSound() {
        System.out.println(getName() + " says: Quack!");
    }

    @Override
    public void fly() {
        System.out.println(getName() + " is flying");
    }

    @Override
    public void swim() {
        System.out.println(getName() + " is swimming");
    }
}

// Abstract class for vehicles
abstract class AbstractVehicle {
    // Common properties
    protected String brand;
    protected int year;

    public AbstractVehicle(String brand, int year) {
        this.brand = brand;
        this.year = year;
    }

    // Common implementation for all vehicles
    public void startEngine() {
        System.out.println("Starting engine of " + brand);
    }

    // Abstract methods that must be implemented by subclasses
    public abstract void accelerate();
    public abstract void applyBrakes();
}

// Interface for things that can be driven
interface Drivable {
    void drive();
    void stop();
}

// Class extending abstract class
class Car extends AbstractVehicle implements Drivable {
    public Car() {
        super("Generic Car", 2020);
    }

    @Override
    public void accelerate() {
        System.out.println("Car is accelerating");
    }

    @Override
    public void applyBrakes() {
        System.out.println("Car is stopping");
    }

    @Override
    public void drive() {
        System.out.println("Driving a real car");
    }

    @Override
    public void stop() {
        applyBrakes();  // Reuse existing method
    }
}

// Specialized car
class SportsCar extends Car {
    @Override
    public void accelerate() {
        System.out.println("Sports car is accelerating quickly");
    }
}

// Unrelated class implementing same interface
class DrivingSimulator implements Drivable {
    @Override
    public void drive() {
        System.out.println("Simulating driving experience");
    }

    @Override
    public void stop() {
        System.out.println("Simulation stopped");
    }
}

// Logging example

// Interface defines contract
interface Logger {
    void log(String message);
    void logError(String message);
}

// Abstract class provides common functionality
abstract class AbstractLogger implements Logger {
    // Template method pattern
    @Override
    public void logError(String message) {
        String errorMsg = "ERROR: " + message;
        log(errorMsg);  // Calls the specialized implementation
    }

    // This must be implemented by subclasses
    @Override
    public abstract void log(String message);
}

// Concrete implementation for console logging
class ConsoleLogger extends AbstractLogger {
    @Override
    public void log(String message) {
        System.out.println("Console: " + message);
    }
}

// Concrete implementation for file logging
class FileLogger extends AbstractLogger {
    private String filename;

    public FileLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void log(String message) {
        System.out.println("File (" + filename + "): " + message);
        // In a real implementation, this would write to a file
    }
}
