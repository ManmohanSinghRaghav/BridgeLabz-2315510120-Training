import java.util.Scanner;

public class OddEvenPrint {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        
        if (number <= 0) {
            System.out.println("Please enter a positive integer");
            return;
        }
        
        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                System.out.println(i + " is even number");
            } else {
                System.out.println(i + " is odd number");
            }
        }
        
        scanner.close();
    }
}
