import java.util.Random;

public class ZaraBonus {

    public static double[][] generateEmployeeData(int numEmployees) {
        double[][] data = new double[numEmployees][2]; // [salary, yearsOfService]
        Random random = new Random();
        for (int i = 0; i < numEmployees; i++) {
            data[i][0] = 10000 + random.nextInt(90000); // 5-digit salary
            data[i][1] = 1 + random.nextInt(10);       // 1-10 years of service
        }
        return data;
    }

    public static double[][] calculateBonusAndNewSalary(double[][] employeeData) {
        double[][] newData = new double[employeeData.length][2]; // [newSalary, bonus]
        for (int i = 0; i < employeeData.length; i++) {
            double oldSalary = employeeData[i][0];
            double years = employeeData[i][1];
            double bonusRate = (years > 5) ? 0.05 : 0.02;
            double bonus = oldSalary * bonusRate;
            newData[i][0] = oldSalary + bonus;
            newData[i][1] = bonus;
        }
        return newData;
    }

    public static void calculateAndDisplayTotals(double[][] oldData, double[][] newData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;
        System.out.println("Emp#\tOld Salary\tYears\tBonus\t\tNew Salary");
        for (int i = 0; i < oldData.length; i++) {
            totalOldSalary += oldData[i][0];
            totalNewSalary += newData[i][0];
            totalBonus += newData[i][1];
            System.out.printf("%d\t%.2f\t%.0f\t%.2f\t%.2f\n", 
                (i+1), oldData[i][0], oldData[i][1], newData[i][1], newData[i][0]);
        }
        System.out.println("----------------------------------------------------------------");
        System.out.printf("Total\t%.2f\t\t%.2f\t%.2f\n", totalOldSalary, totalBonus, totalNewSalary);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData(10);
        double[][] newData = calculateBonusAndNewSalary(employeeData);
        calculateAndDisplayTotals(employeeData, newData);
    }
}
