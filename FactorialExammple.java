import java.util.Scanner;

class FactorialCalculator {
    public long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            long factorial = 1;
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
            return factorial;
        }
    }
}

public class FactorialExammple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number to find its factorial: ");
        int num = scanner.nextInt();

        FactorialCalculator calculator = new FactorialCalculator();
        long factorial = calculator.calculateFactorial(num);

        System.out.println("Factorial of " + num + " is: " + factorial);
    }
}
