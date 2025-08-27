import java.util.Scanner;

public class EmployeeBonus {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = 10;
        double[][] data = new double[n][2];
        double[][] res = new double[n][2];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        for (int i = 0; i < n; i++) {
            System.out.println("Enter salary for employee " + (i + 1) + ":");
            double salary = scn.nextDouble();
            System.out.println("Enter years of service for employee " + (i + 1) + ":");
            double years = scn.nextDouble();

            if (salary <= 0 || years < 0) {
                System.out.println("Invalid input. Please enter again.");
                i--;
                continue;
            }
            data[i][0] = salary;
            data[i][1] = years;
        }

;
        for (int i = 0; i < n; i++) {
            double salary = data[i][0];
            double years = data[i][1];
            double bonus = (years > 5) ? salary * 0.05 : salary * 0.02;
            double newSalary = salary + bonus;

            res[i][0] = newSalary;
            res[i][1] = bonus;

            totalBonus += bonus;
            totalOldSalary += salary;
            totalNewSalary += newSalary;
        }

;
        System.out.println("\nEmployee\tOld Salary\tYears\tBonus\tNew Salary");
        for (int i = 0; i < n; i++) {
            System.out.printf("%d\t\t%.2f\t\t%.1f\t%.2f\t%.2f\n", 
                (i + 1), data[i][0], data[i][1], res[i][1], res[i][0]);
        }
        System.out.printf("\nTotal Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
    }
}
