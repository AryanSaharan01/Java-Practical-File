import java.util.Scanner;

class Person {
    private String name;
    private int age;

    public void getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = scanner.nextLine();
        System.out.print("Enter Age: ");
        age = scanner.nextInt();
    }

    public void displayData() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

public class PersonInfo {
    public static void main(String[] args) {
        Person person = new Person();
        person.getInput();
        System.out.println("Displaying Entered Data:");
        person.displayData();
    }
}
