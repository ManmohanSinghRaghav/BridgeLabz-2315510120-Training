import java.util.Scanner;

public class PowerCalculatorFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the power: ");
        int power = scanner.nextInt();
        
        if (power < 0) {
            System.out.println("Please enter a non-negative power");
            return;
        }
        
        long result = 1;
        
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        
        System.out.println(number + " raised to power " + power + " is: " + result);
        scanner.close();
    }
}
