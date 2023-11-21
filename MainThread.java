import java.util.Random;

class NumberGenerator extends Thread {
    private Random random = new Random();

    public void run() {
        try {
            while (true) {
                int number = random.nextInt(100); // Generate a random integer between 0 and 99
                System.out.println("Generated Number: " + number);

                if (number % 2 == 0) {
                    synchronized (MainThread.squareThread) {
                        MainThread.squareThread.setNumber(number);
                        MainThread.squareThread.notify();
                    }
                } else {
                    synchronized (MainThread.cubeThread) {
                        MainThread.cubeThread.setNumber(number);
                        MainThread.cubeThread.notify();
                    }
                }

                Thread.sleep(1000); // Sleep for 1 second
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class SquareThread extends Thread {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    wait(); // Wait for notification from the NumberGenerator
                    int square = number * number;
                    System.out.println("Square of " + number + " is " + square);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

class CubeThread extends Thread {
    private int number;

    public void setNumber(int number) {
        this.number = number;
    }

    public void run() {
        try {
            while (true) {
                synchronized (this) {
                    wait(); // Wait for notification from the NumberGenerator
                    int cube = number * number * number;
                    System.out.println("Cube of " + number + " is " + cube);
                }
            }
        } catch (InterruptedException e) {
            System.out.println(e);
        }
    }
}

public class MainThread {
    public static SquareThread squareThread;
    public static CubeThread cubeThread;

    public static void main(String[] args) {
        squareThread = new SquareThread();
        cubeThread = new CubeThread();

        NumberGenerator numberGenerator = new NumberGenerator();
        numberGenerator.start();
        squareThread.start();
        cubeThread.start();
    }
}
