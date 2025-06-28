package FrequentInterviewQuestions;

/**
 * This class demonstrates Polymorphism in Java
 * 
 * Polymorphism is the ability of an object to take on many forms.
 * The word polymorphism means having many forms.
 * 
 * There are two types of polymorphism in Java:
 * 1. Compile-time polymorphism (Static binding) - Method overloading
 * 2. Runtime polymorphism (Dynamic binding) - Method overriding
 */
public class PolymorphismDemo {

    public static void main(String[] args) {
        System.out.println("===== Polymorphism Demonstration =====");

        // 1. Compile-Time Polymorphism (Method Overloading)
        demonstrateMethodOverloading();

        // 2. Runtime Polymorphism (Method Overriding)
        demonstrateMethodOverriding();

        // Additional examples
        demonstrateOperatorOverloading();
        demonstratePolymorphicVariables();
        demonstrateInstanceOf();
    }

    /**
     * Demonstrates Method Overloading (Compile-time Polymorphism)
     * Method overloading occurs when a class has multiple methods with the same name
     * but different parameters (different number, type, or order of parameters).
     */
    private static void demonstrateMethodOverloading() {
        System.out.println("\n1. Method Overloading (Compile-time Polymorphism):");

        MathOperation math = new MathOperation();

        // Same method name but different parameter types/counts
        System.out.println("Adding two integers: " + math.add(5, 10));  // Calls add(int, int)
        System.out.println("Adding three integers: " + math.add(5, 10, 15));  // Calls add(int, int, int)
        System.out.println("Adding two doubles: " + math.add(5.5, 10.5));  // Calls add(double, double)
        System.out.println("Adding int and double: " + math.add(5, 10.5));  // Calls add(int, double)

        // The compiler determines which method to call based on the arguments
        // This is known as static binding or compile-time polymorphism
    }

    /**
     * Demonstrates Method Overriding (Runtime Polymorphism)
     * Method overriding occurs when a subclass provides a specific implementation
     * for a method that is already defined in its parent class.
     */
    private static void demonstrateMethodOverriding() {
        System.out.println("\n2. Method Overriding (Runtime Polymorphism):");

        // Create an array of Vehicle references pointing to different vehicle objects
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Vehicle("Generic Vehicle", "Unknown");
        vehicles[1] = new Car("Toyota Camry", "Sedan", 4);
        vehicles[2] = new Motorcycle("Harley Davidson", "Cruiser", false);

        // Polymorphic method calls - the JVM decides which method to call at runtime
        // based on the actual object type, not the reference type
        for (Vehicle vehicle : vehicles) {
            System.out.println("\nVehicle details: " + vehicle.getName() + " - " + vehicle.getType());

            // This method is overridden in subclasses
            vehicle.start();  // Calls the appropriate version based on the actual object
            vehicle.move();   // Common implementation from parent class
            vehicle.stop();   // Common implementation from parent class

            // This is how the overridden method is resolved at runtime
            // based on the actual object type (dynamic binding)
        }
    }

    /**
     * Demonstrates Operator Overloading (limited in Java)
     * Unlike some other languages, Java doesn't support direct operator overloading,
     * but it has some built-in operator overloading like the + operator for String concatenation.
     */
    private static void demonstrateOperatorOverloading() {
        System.out.println("\n3. Operator Overloading (Limited in Java):");

        // + operator behaves differently based on operand types
        int a = 10;
        int b = 20;
        System.out.println("Addition for integers: " + a + " + " + b + " = " + (a + b));  // Arithmetic addition

        String str1 = "Hello";
        String str2 = "World";
        System.out.println("Addition for strings: " + str1 + " + " + str2 + " = " + (str1 + str2));  // String concatenation

        System.out.println("Mixed addition: " + a + " + " + str1 + " = " + (a + str1));  // int converted to String
    }

    /**
     * Demonstrates polymorphic variables and parameter passing
     */
    private static void demonstratePolymorphicVariables() {
        System.out.println("\n4. Polymorphic Variables and Parameters:");

        // Parent class reference can hold a child class object
        Vehicle genericVehicle = new Vehicle("Generic", "Unknown");
        Vehicle carAsVehicle = new Car("Ford Mustang", "Sports Car", 2);  // Polymorphic assignment

        System.out.println("\nCalling methods directly:");
        genericVehicle.start();  // Calls Vehicle's start()
        carAsVehicle.start();    // Calls Car's start() - polymorphic behavior

        // This demonstrates upcasting (implicit)
        // Upcasting is always safe as a subclass is always a specialized version of its superclass

        // Polymorphic method parameters
        System.out.println("\nPolymorphic method parameters:");
        startVehicle(genericVehicle);  // Pass Vehicle object
        startVehicle(carAsVehicle);    // Pass Car object as Vehicle
        startVehicle(new Motorcycle("Ducati", "Sport", true));  // Pass Motorcycle object as Vehicle
    }

    /**
     * Helper method that accepts any Vehicle type (or its subclasses)
     */
    private static void startVehicle(Vehicle vehicle) {
        System.out.println("Starting: " + vehicle.getName());
        vehicle.start();  // Polymorphic call

        // We can check the actual type at runtime
        if (vehicle instanceof Car) {
            System.out.println("This is a car with " + ((Car) vehicle).getDoorCount() + " doors");
            // This requires downcasting (explicit casting from parent to child)
            // Downcasting can be dangerous and should be checked with instanceof
        } else if (vehicle instanceof Motorcycle) {
            Motorcycle bike = (Motorcycle) vehicle;  // Downcasting
            System.out.println("This is a motorcycle" + 
                (bike.hasWindshield() ? " with a windshield" : " without a windshield"));
        }
    }

    /**
     * Demonstrates instanceof operator and type checking/casting
     */
    private static void demonstrateInstanceOf() {
        System.out.println("\n5. instanceof Operator and Type Casting:");

        // Create objects
        Vehicle vehicle = new Vehicle("Generic", "Basic");
        Vehicle car = new Car("Honda Civic", "Sedan", 4);
        Car actualCar = new Car("BMW", "Coupe", 2);

        // Check types with instanceof
        System.out.println("vehicle instanceof Vehicle: " + (vehicle instanceof Vehicle));  // true
        System.out.println("vehicle instanceof Car: " + (vehicle instanceof Car));  // false
        System.out.println("car instanceof Vehicle: " + (car instanceof Vehicle));  // true
        System.out.println("car instanceof Car: " + (car instanceof Car));  // true
        System.out.println("actualCar instanceof Vehicle: " + (actualCar instanceof Vehicle));  // true

        // Safe downcasting with instanceof check
        System.out.println("\nSafe downcasting example:");
        processVehicle(vehicle);
        processVehicle(car);
        processVehicle(actualCar);
    }

    /**
     * Helper method that safely downcasts when appropriate
     */
    private static void processVehicle(Vehicle v) {
        System.out.println("Processing vehicle: " + v.getName());

        if (v instanceof Car) {
            // Safe downcasting after instanceof check
            Car c = (Car) v;
            c.honk();  // Car-specific method
            System.out.println("This car has " + c.getDoorCount() + " doors");
        } else {
            System.out.println("This is not a car");
        }
    }
}

// Classes for demonstrating Method Overloading
class MathOperation {
    // Overloaded methods - same name, different parameters
    public int add(int a, int b) {
        return a + b;
    }

    public int add(int a, int b, int c) {
        return a + b + c;
    }

    public double add(double a, double b) {
        return a + b;
    }

    public double add(int a, double b) {
        return a + b;
    }
}

// Classes for demonstrating Method Overriding
class Vehicle {
    private String name;
    private String type;

    public Vehicle(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    // Methods that can be overridden by subclasses
    public void start() {
        System.out.println("Vehicle starting");
    }

    public void move() {
        System.out.println("Vehicle moving");
    }

    public void stop() {
        System.out.println("Vehicle stopped");
    }
}

class Car extends Vehicle {
    private int doorCount;

    public Car(String name, String type, int doorCount) {
        super(name, type);  // Call parent constructor
        this.doorCount = doorCount;
    }

    public int getDoorCount() {
        return doorCount;
    }

    // Car-specific method
    public void honk() {
        System.out.println("Car honking: Beep beep!");
    }

    // Overriding the parent method
    @Override
    public void start() {
        System.out.println("Car engine starting");
    }
}

class Motorcycle extends Vehicle {
    private boolean hasWindshield;

    public Motorcycle(String name, String type, boolean hasWindshield) {
        super(name, type);  // Call parent constructor
        this.hasWindshield = hasWindshield;
    }

    public boolean hasWindshield() {
        return hasWindshield;
    }

    // Overriding the parent method
    @Override
    public void start() {
        System.out.println("Motorcycle engine kick-starting");
    }
}
