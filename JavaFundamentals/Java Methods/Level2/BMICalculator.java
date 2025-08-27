import java.util.Scanner;

public class BMICalculator {

    public static void calculateBMI(double[][] data) {
        for (int i = 0; i < data.length; i++) {
            double weight = data[i][0];
            double heightInCm = data[i][1];
            double heightInM = heightInCm / 100.0;
            data[i][2] = weight / (heightInM * heightInM);
        }
    }

    public static String getBMIStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25) {
            return "Normal weight";
        } else if (bmi < 30) {
            return "Overweight";
        } else {
            return "Obesity";
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] teamData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            teamData[i][0] = scanner.nextDouble();
            System.out.print("Enter height (cm) for person " + (i + 1) + ": ");
            teamData[i][1] = scanner.nextDouble();
        }

        calculateBMI(teamData);

        System.out.println("\n--- BMI Results ---");
        for (int i = 0; i < 10; i++) {
            double weight = teamData[i][0];
            double height = teamData[i][1];
            double bmi = teamData[i][2];
            String status = getBMIStatus(bmi);
            System.out.printf("Person %d: Weight=%.1fkg, Height=%.1fcm, BMI=%.2f, Status=%s\n",
                    (i + 1), weight, height, bmi, status);
        }
        scanner.close();
    }
}
