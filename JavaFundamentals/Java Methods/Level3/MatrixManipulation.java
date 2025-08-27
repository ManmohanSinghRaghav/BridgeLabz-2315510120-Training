import java.util.Random;

public class MatrixManipulation {

    public static int[][] createRandomMatrix(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = random.nextInt(10); // values 0-9
            }
        }
        return matrix;
    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int val : row) {
                System.out.print(val + "\t");
            }
            System.out.println();
        }
    }

    // --- Part 1: Basic Operations ---
    public static int[][] addMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return null;
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }

    public static int[][] subtractMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return null;
        int[][] result = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b) {
        if (a[0].length != b.length) return null;
        int[][] result = new int[a.length][b[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    // --- Part 2: Advanced Operations ---
    public static int[][] transpose(int[][] matrix) {
        int[][] result = new int[matrix[0].length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[j][i] = matrix[i][j];
            }
        }
        return result;
    }

    public static int determinant2x2(int[][] matrix) {
        if (matrix.length != 2 || matrix[0].length != 2) return 0; // Or throw exception
        return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
    }

    // Note: Inverse and 3x3 determinant are more complex and omitted for brevity in this example.
    // A full implementation would require more code, especially for the 3x3 inverse.

    public static void main(String[] args) {
        int[][] A = createRandomMatrix(2, 3);
        int[][] B = createRandomMatrix(3, 2);
        
        System.out.println("Matrix A:");
        displayMatrix(A);
        System.out.println("\nMatrix B:");
        displayMatrix(B);

        System.out.println("\nProduct A * B:");
        int[][] C = multiplyMatrices(A, B);
        if (C != null) displayMatrix(C);

        System.out.println("\nTranspose of A:");
        int[][] T = transpose(A);
        displayMatrix(T);

        int[][] D = {{4, 7}, {2, 6}};
        System.out.println("\nDeterminant of [[4, 7], [2, 6]]: " + determinant2x2(D));
    }
}
