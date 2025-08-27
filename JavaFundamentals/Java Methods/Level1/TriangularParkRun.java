import java.util.Scanner;

public class TriangularParkRun {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        return 5000 / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the length of the first side of the park (in meters): ");
        double side1 = scanner.nextDouble();

        System.out.print("Enter the length of the second side of the park (in meters): ");
        double side2 = scanner.nextDouble();

        System.out.print("Enter the length of the third side of the park (in meters): ");
        double side3 = scanner.nextDouble();

        double rounds = calculateRounds(side1, side2, side3);

        System.out.println("The athlete must complete " + rounds + " rounds to complete a 5 km run.");

        scanner.close();
    }
}
