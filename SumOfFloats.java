public class SumOfFloats {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two float numbers as command-line arguments.");
            return;
        }

        float num1 = Float.parseFloat(args[0]);
        float num2 = Float.parseFloat(args[1]);

        float sum = num1 + num2;

        System.out.println("Sum of the two float numbers is: " + sum);
    }
}
