import java.util.Scanner;

public class NaturalSumFor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a natural number: ");
        int n = scanner.nextInt();
        
        if (n <= 0) {
            System.out.println("Please enter a positive integer");
            return;
        }
        
        // Using formula
        int formulaSum = n * (n + 1) / 2;
        
        // Using for loop
        int loopSum = 0;
        for (int i = 1; i <= n; i++) {
            loopSum += i;
        }
        
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Sum using for loop: " + loopSum);
        System.out.println("Results match: " + (formulaSum == loopSum));
        
        scanner.close();
    }
}