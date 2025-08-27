import java.util.Scanner;

public class FriendChallenge {

    public static String findYoungest(String[] names, int[] ages) {
        int minAge = Integer.MAX_VALUE;
        String youngestFriend = "";
        for (int i = 0; i < ages.length; i++) {
            if (ages[i] < minAge) {
                minAge = ages[i];
                youngestFriend = names[i];
            }
        }
        return youngestFriend;
    }

    public static String findTallest(String[] names, double[] heights) {
        double maxHeight = 0;
        String tallestFriend = "";
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > maxHeight) {
                maxHeight = heights[i];
                tallestFriend = names[i];
            }
        }
        return tallestFriend;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] ages = new int[3];
        double[] heights = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.print("Enter age for " + names[i] + ": ");
            ages[i] = scanner.nextInt();
            System.out.print("Enter height for " + names[i] + " (in cm): ");
            heights[i] = scanner.nextDouble();
        }

        String youngest = findYoungest(names, ages);
        String tallest = findTallest(names, heights);

        System.out.println("The youngest friend is: " + youngest);
        System.out.println("The tallest friend is: " + tallest);

        scanner.close();
    }
}
