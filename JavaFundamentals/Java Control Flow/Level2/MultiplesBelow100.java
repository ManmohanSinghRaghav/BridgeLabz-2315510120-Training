import java.util.Scanner;

public class MultiplesBelow100 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a positive integer less than 100: ");
        int number = scanner.nextInt();
        
        if (number <= 0 || number >= 100) {
            System.out.println("Please enter a positive integer less than 100");
            return;
        }
        
        System.out.println("Multiples of " + number + " below 100 are:");
        for (int i = number; i < 100; i += number) {
            System.out.println(i);
        }
        
        scanner.close();
    }
}
