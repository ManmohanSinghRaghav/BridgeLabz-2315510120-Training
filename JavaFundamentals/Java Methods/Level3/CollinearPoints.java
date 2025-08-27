import java.util.Scanner;

public class CollinearPoints {

    public static boolean areCollinearBySlope(double x1, double y1, double x2, double y2, double x3, double y3) {
        if (x2 - x1 == 0 || x3 - x2 == 0) { // Vertical line check
            return x2 - x1 == 0 && x3 - x2 == 0;
        }
        double slopeAB = (y2 - y1) / (x2 - x1);
        double slopeBC = (y3 - y2) / (x3 - x2);
        return Math.abs(slopeAB - slopeBC) < 1e-9; // Compare floating point numbers
    }

    public static boolean areCollinearByArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        double area = 0.5 * (x1 * (y2 - y3) + x2 * (y3 - y1) + x3 * (y1 - y2));
        return Math.abs(area) < 1e-9;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter coordinates for point 1 (x1 y1):");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        System.out.println("Enter coordinates for point 2 (x2 y2):");
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        System.out.println("Enter coordinates for point 3 (x3 y3):");
        double x3 = scanner.nextDouble();
        double y3 = scanner.nextDouble();

        System.out.println("Using slope formula: " + (areCollinearBySlope(x1, y1, x2, y2, x3, y3) ? "Collinear" : "Not Collinear"));
        System.out.println("Using area formula: " + (areCollinearByArea(x1, y1, x2, y2, x3, y3) ? "Collinear" : "Not Collinear"));
        scanner.close();
    }
}
