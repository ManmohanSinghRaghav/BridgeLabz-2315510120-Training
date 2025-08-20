import java.util.Scanner;

class TriangleAreaCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter base of triangle: ");
        double base = input.nextDouble();
        
        System.out.print("Enter height of triangle: ");
        double height = input.nextDouble();
        
        double areaSquareInches = 0.5 * base * height;
        double conversionFactor = 6.4516;
        double areaSquareCm = areaSquareInches * conversionFactor;
        
        System.out.println("Area of triangle is " + areaSquareInches + " square inches and " + areaSquareCm + " square centimeters");
        
        input.close();
    }
}