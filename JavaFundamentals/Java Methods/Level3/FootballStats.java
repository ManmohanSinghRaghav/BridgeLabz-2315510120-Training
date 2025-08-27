import java.util.Arrays;
import java.util.Random;

public class FootballStats {

    public static int[] generateRandomHeights(int size) {
        int[] heights = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            heights[i] = 150 + random.nextInt(101); // 150 to 250
        }
        return heights;
    }

    public static int sum(int[] arr) {
        int total = 0;
        for (int h : arr) {
            total += h;
        }
        return total;
    }

    public static double mean(int[] arr) {
        return (double) sum(arr) / arr.length;
    }

    public static int shortest(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int h : arr) {
            if (h < min) {
                min = h;
            }
        }
        return min;
    }

    public static int tallest(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int h : arr) {
            if (h > max) {
                max = h;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] heights = generateRandomHeights(11);
        System.out.println("Player heights (cm): " + Arrays.toString(heights));
        System.out.printf("Mean height: %.2f cm\n", mean(heights));
        System.out.println("Shortest height: " + shortest(heights) + " cm");
        System.out.println("Tallest height: " + tallest(heights) + " cm");
    }
}
