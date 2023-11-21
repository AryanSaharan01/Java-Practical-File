// Define an interface
interface Vehicle {
    void start();
    void stop();
    void accelerate(int speed);
}

// Implement the interface in a class
class Car implements Vehicle {
    @Override
    public void start() {
        System.out.println("Car started");
    }

    @Override
    public void stop() {
        System.out.println("Car stopped");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Car is accelerating at " + speed + " km/h");
    }
}

class Bike implements Vehicle {
    @Override
    public void start() {
        System.out.println("Bike started");
    }

    @Override
    public void stop() {
        System.out.println("Bike stopped");
    }

    @Override
    public void accelerate(int speed) {
        System.out.println("Bike is accelerating at " + speed + " km/h");
    }
}

public class InterfaceExample {
    public static void main(String[] args) {
        Vehicle car = new Car();
        Vehicle bike = new Bike();

        car.start();
        car.accelerate(60);
        car.stop();

        System.out.println();

        bike.start();
        bike.accelerate(40);
        bike.stop();
    }
}
