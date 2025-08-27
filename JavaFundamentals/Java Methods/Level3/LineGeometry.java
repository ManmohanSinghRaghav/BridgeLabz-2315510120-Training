import java.util.Scanner;

public class LineGeometry {

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static double[] findLineEquation(double x1, double y1, double x2, double y2) {
        if (x2 - x1 == 0) { // Vertical line
            return null; // Or handle as special case, slope is infinite
        }
        double slope = (y2 - y1) / (x2 - x1);
        double yIntercept = y1 - slope * x1;
        return new double[]{slope, yIntercept};
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates for point 1 (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Enter coordinates for point 2 (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();

        System.out.printf("Euclidean Distance: %.2f\n", calculateDistance(x1, y1, x2, y2));

        double[] equation = findLineEquation(x1, y1, x2, y2);
        if (equation != null) {
            System.out.printf("Equation of the line: y = %.2fx + %.2f\n", equation[0], equation[1]);
        } else {
            System.out.println("The line is vertical: x = " + x1);
        }
        scanner.close();
    }
}
