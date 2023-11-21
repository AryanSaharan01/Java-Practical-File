public class MultipleCatchExample {
    public static void main(String[] args) {
        try {
            int[] arr = { 1, 2, 3 };
            System.out.println(arr[4]); // This will cause an ArrayIndexOutOfBoundsException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index out of bounds exception");
        } catch (ArithmeticException ae) {
            System.out.println("Arithmetic exception: " + ae.getMessage());
        } catch (Exception ex) {
            System.out.println("General exception: " + ex.getMessage());
        }
    }
}
