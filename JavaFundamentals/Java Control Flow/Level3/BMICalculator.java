import java.util.Scanner;

public class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter weight (in kg): ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height (in cm): ");
        double height = scanner.nextDouble();
        
        // Convert height from cm to meters
        double heightInMeters = height / 100;
        
        // Calculate BMI
        double bmi = weight / (heightInMeters * heightInMeters);
        
        System.out.printf("BMI: %.2f%n", bmi);
        
        String status;
        if (bmi < 18.5) {
            status = "Underweight";
        } else if (bmi < 25) {
            status = "Normal weight";
        } else if (bmi < 30) {
            status = "Overweight";
        } else {
            status = "Obese";
        }
        
        System.out.println("Weight Status: " + status);
        scanner.close();
    }
}
