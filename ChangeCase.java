import java.util.Scanner;

public class ChangeCase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char inputChar = scanner.next().charAt(0);

        if (Character.isUpperCase(inputChar)) {
            char lowerCaseChar = Character.toLowerCase(inputChar);
            System.out.println("Character in lower case: " + lowerCaseChar);
        } else if (Character.isLowerCase(inputChar)) {
            char upperCaseChar = Character.toUpperCase(inputChar);
            System.out.println("Character in upper case: " + upperCaseChar);
        } else {
            System.out.println("Not a valid alphabet character.");
        }
    }
}

