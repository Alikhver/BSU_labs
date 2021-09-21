package lab3.example11;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.close();

        if (n <= 0) {
            System.out.println("Entry value is incorrect");
            System.exit(0);
        }

        int[][] matrix = new int[n][n];

        fillTheMatrix(matrix);

        printTheMatrix(matrix);

        int result = func(matrix);

        System.out.println(result);
    }


    static void printTheMatrix(int[][] matrix) {
        int x = matrix.length;
        for (int[] arr : matrix) {
            for (int j = 0; j < x; j++) {
                System.out.print(arr[j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

    static void fillTheMatrix(int[][] matrix) {
        int x = matrix.length;

        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                matrix[i][j] = (int) Math.floor(Math.random() * 2 * x - x + 1);
            }
        }
    }

    static int func(int[][] matrix) {
        int amount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    amount++;
                }
            }
        }
        System.out.println();
        return amount;
    }

    static boolean isLocalMinimum(int[][] matrix, int i, int j) {
        for (int k = i - 1; k <= i + 1; k++) {
            if (k == -1 || k == matrix.length) {
                continue;
            }
            for (int m = j - 1; m <= j + 1; m++) {
                if (m == -1 || m == matrix.length || (m == j && k == i)) {
                    continue;
                }
                if (matrix[i][j] >= matrix[k][m]) {
                    return false;
                }
            }
        }
        System.out.print(i + " " + j + "; ");
        System.out.println(matrix[i][j]);
        return true;
    }
}
