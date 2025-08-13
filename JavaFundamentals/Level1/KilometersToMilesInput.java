import java.util.Scanner;

class KilometersToMilesInput {
    public static void main(String[] args) {
        double km;
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter distance in kilometers: ");
        km = input.nextDouble();
        
        double conversionFactor = 1.6;
        double miles = km / conversionFactor;
        
        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        
        input.close();
    }
}