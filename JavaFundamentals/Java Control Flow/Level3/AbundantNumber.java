import java.util.Scanner;

public class AbundantNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        
        int sum = 0;
        
        System.out.print("Divisors of " + number + ": ");
        for (int i = 1; i < number; i++) {
            if (number % i == 0) {
                System.out.print(i + " ");
                sum += i;
            }
        }
        
        System.out.println();
        System.out.println("Sum of divisors: " + sum);
        
        if (sum > number) {
            System.out.println(number + " is an Abundant Number");
        } else {
            System.out.println(number + " is not an Abundant Number");
        }
        
        scanner.close();
    }
}
