import java.util.Scanner;

public class NaturalSumWhile {
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
        
        // Using while loop
        int loopSum = 0;
        int i = 1;
        while (i <= n) {
            loopSum += i;
            i++;
        }
        
        System.out.println("Sum using formula: " + formulaSum);
        System.out.println("Sum using while loop: " + loopSum);
        System.out.println("Results match: " + (formulaSum == loopSum));
        
        scanner.close();
    }
}