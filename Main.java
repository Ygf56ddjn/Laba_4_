import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[][] array = {
                {5, 3, 8, 1, 2},
                {9, 6, 4, 7, 0},
                {3, 5, 1, 8, 6}
        };
        for (int i = 0; i < array.length; i++) {
            shakerSort(array[i]);
        }

        printArray(array);
    }
    public static void shakerSort(int[] row) {
        int left = 0;
        int right = row.length - 1;
        boolean swapped;

        do {
            swapped = false;
            for (int i = left; i < right; i++) {
                if (row[i] > row[i + 1]) {
                    int temp = row[i];
                    row[i] = row[i + 1];
                    row[i + 1] = temp;
                    swapped = true;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (row[i] < row[i - 1]) {
                    int temp = row[i];
                    row[i] = row[i - 1];
                    row[i - 1] = temp;
                    swapped = true;
                }
            }
            left++;
        } while (swapped);
    }
    public static void printArray(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
