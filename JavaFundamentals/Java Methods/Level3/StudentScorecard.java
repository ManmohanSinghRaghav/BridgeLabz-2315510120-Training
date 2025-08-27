import java.util.Random;
import java.util.Scanner;

public class StudentScorecard {

    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3]; // PCM
        Random random = new Random();
        for (int i = 0; i < numStudents; i++) {
            scores[i][0] = random.nextInt(101); // Physics
            scores[i][1] = random.nextInt(101); // Chemistry
            scores[i][2] = random.nextInt(101); // Math
        }
        return scores;
    }

    public static double[][] calculateStats(int[][] scores) {
        double[][] stats = new double[scores.length][3]; // Total, Avg, Pct
        for (int i = 0; i < scores.length; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            stats[i][0] = total;
            stats[i][1] = Math.round((total / 3.0) * 100.0) / 100.0;
            stats[i][2] = Math.round((total / 300.0) * 100.0 * 100.0) / 100.0;
        }
        return stats;
    }

    public static void displayScorecard(int[][] scores, double[][] stats) {
        System.out.println("Std#\tPhys\tChem\tMath\tTotal\tAvg\tPercent");
        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%%\n",
                (i + 1), scores[i][0], scores[i][1], scores[i][2],
                stats[i][0], stats[i][1], stats[i][2]);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        
        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateStats(scores);
        displayScorecard(scores, stats);
        
        scanner.close();
    }
}
