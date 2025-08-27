public class Rmv {
    public static void main(String[] args) {
        int[] arr = {0, 1, 3, 0, 2, 2, 4, 2};
        int num = 2;
        // System.out.println(rem(arr, num));
        for (int i: rep(arr, num)) {
            System.out.print(i + " ");
        }
    }

    public static int rem(int[] arr, int num) {
        int len = arr.length;
        for (int i: arr) {
            if  (i == num) len--; 
        }
        return len;
    }

    public static int[] rep(int[] arr, int num) {
        int i = 0;
        int[] newArr = new int[arr.length];
        for (int n: arr) {
            if (num != n) {
                newArr[i] = n;
                i++;
            }
        }
        return newArr;
    }
}
