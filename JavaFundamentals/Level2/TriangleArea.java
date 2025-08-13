import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter base in cm: ");
        double base = scanner.nextDouble();
        
        System.out.print("Enter height in cm: ");
        double height = scanner.nextDouble();
        
        double areaInCm = 0.5 * base * height;
        double areaInInches = areaInCm / (2.54 * 2.54); // Convert cm² to in²
        
        System.out.printf("The Area of the triangle in sq in is %.2f and sq cm is %.2f%n", 
                         areaInInches, areaInCm);
        
        scanner.close();
    }
}
