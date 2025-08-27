import java.util.Scanner;

public class RecursiveSum {

    public static int sumRecursive(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sumRecursive(n - 1);
    }

    public static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a natural number: ");
        int number = scanner.nextInt();

        if (number < 1) {
            System.out.println("Please enter a natural number (>= 1).");
        } else {
            int recursiveResult = sumRecursive(number);
            int formulaResult = sumFormula(number);

            System.out.println("Sum using recursion: " + recursiveResult);
            System.out.println("Sum using formula: " + formulaResult);

            if (recursiveResult == formulaResult) {
                System.out.println("The results from both computations are correct.");
            } else {
                System.out.println("There is a discrepancy in the results.");
            }
        }
        scanner.close();
    }
}
