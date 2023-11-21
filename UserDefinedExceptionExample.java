// Custom exception class
class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }
}

public class UserDefinedExceptionExample {
    public static void main(String[] args) {
        try {
            int age = 15;
            if (age < 18) {
                throw new MyException("You are not eligible to vote.");
            } else {
                System.out.println("You are eligible to vote.");
            }
        } catch (MyException e) {
            System.out.println("Caught MyException: " + e.getMessage());
        }
    }
}
