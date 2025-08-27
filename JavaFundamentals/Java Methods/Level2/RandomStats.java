import java.util.Arrays;

public class RandomStats {

    public int[] generate4DigitRandomArray(int size) {
        int[] randomArray = new int[size];
        for (int i = 0; i < size; i++) {
            randomArray[i] = 1000 + (int) (Math.random() * 9000);
        }
        return randomArray;
    }

    public double[] findAverageMinMax(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return new double[0];
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double sum = 0;

        for (int number : numbers) {
            sum += number;
            if (number < min) {
                min = number;
            }
            if (number > max) {
                max = number;
            }
        }

        double average = sum / numbers.length;
        return new double[]{average, (double) min, (double) max};
    }

    public static void main(String[] args) {
        RandomStats rs = new RandomStats();
        int[] randomNumbers = rs.generate4DigitRandomArray(5);
        System.out.println("Generated random numbers: " + Arrays.toString(randomNumbers));

        double[] stats = rs.findAverageMinMax(randomNumbers);
        if (stats.length == 3) {
            System.out.printf("Average: %.2f, Min: %.0f, Max: %.0f\n", stats[0], stats[1], stats[2]);
        }
    }
}