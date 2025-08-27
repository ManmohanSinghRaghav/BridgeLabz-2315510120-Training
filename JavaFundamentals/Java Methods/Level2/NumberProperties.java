import java.util.Scanner;

public class NumberProperties {

    public static boolean isPositive(int number) {
        return number > 0;
    }

    public static boolean isEven(int number) {
        return number % 2 == 0;
    }

    public static int compare(int number1, int number2) {
        if (number1 > number2) {
            return 1;
        } else if (number1 < number2) {
            return -1;
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int number : numbers) {
            if (isPositive(number)) {
                System.out.print(number + " is positive and ");
                if (isEven(number)) {
                    System.out.println("even.");
                } else {
                    System.out.println("odd.");
                }
            } else {
                System.out.println(number + " is negative or zero.");
            }
        }

        int comparisonResult = compare(numbers[0], numbers[numbers.length - 1]);
        System.out.print("Comparing the first and last elements: ");
        if (comparisonResult == 1) {
            System.out.println("First is greater than last.");
        } else if (comparisonResult == -1) {
            System.out.println("First is less than last.");
        } else {
            System.out.println("They are equal.");
        }
        scanner.close();
    }
}
