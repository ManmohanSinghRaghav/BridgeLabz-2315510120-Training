import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter marks in Physics: ");
        double physics = scanner.nextDouble();
        System.out.print("Enter marks in Chemistry: ");
        double chemistry = scanner.nextDouble();
        System.out.print("Enter marks in Maths: ");
        double maths = scanner.nextDouble();
        
        double total = physics + chemistry + maths;
        double percentage = total / 3;
        
        System.out.println("Average Mark: " + percentage);
        
        char grade;
        String remarks;
        
        if (percentage >= 90) {
            grade = 'A';
            remarks = "Excellent";
        } else if (percentage >= 80) {
            grade = 'B';
            remarks = "Good";
        } else if (percentage >= 70) {
            grade = 'C';
            remarks = "Fair";
        } else if (percentage >= 60) {
            grade = 'D';
            remarks = "Meets Expectations";
        } else {
            grade = 'F';
            remarks = "Below Expectations";
        }
        
        System.out.println("Grade: " + grade);
        System.out.println("Remarks: " + remarks);
        
        scanner.close();
    }
}
