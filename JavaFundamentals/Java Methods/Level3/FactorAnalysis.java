import java.util.Arrays;

public class FactorAnalysis {

    public static int[] findFactors(int number) {
        int count = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) count++;
        }
        int[] factors = new int[count];
        int index = 0;
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) factors[index++] = i;
        }
        return factors;
    }

    public static int greatestFactor(int[] factors) {
        return factors.length > 1 ? factors[factors.length - 2] : 1; // Proper divisor
    }

    public static long sumFactors(int[] factors) {
        long sum = 0;
        for (int f : factors) sum += f;
        return sum;
    }

    public static long productFactors(int[] factors) {
        long prod = 1;
        for (int f : factors) prod *= f;
        return prod;
    }

    public static double productOfCubeOfFactors(int[] factors) {
        double prod = 1.0;
        for (int f : factors) {
            prod *= Math.pow(f, 3);
        }
        return prod;
    }

    public static void main(String[] args) {
        int num = 12;
        int[] factors = findFactors(num);
        System.out.println("Factors of " + num + ": " + Arrays.toString(factors));
        System.out.println("Greatest proper factor: " + greatestFactor(factors));
        System.out.println("Sum of factors: " + sumFactors(factors));
        System.out.println("Product of factors: " + productFactors(factors));
        System.out.println("Product of cube of factors: " + productOfCubeOfFactors(factors));
    }
}
