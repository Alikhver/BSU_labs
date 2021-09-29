package lab3.example11;

import java.sql.SQLOutput;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int length;

        System.out.println("Enter length of square matrix");
        try (Scanner scanner = new Scanner(System.in)) {
            length = scanner.nextInt();
        }

        if (length <= 0) {
            System.out.println("Entry value is incorrect");
            System.exit(0);
        }

        MyMatrix myMatrix = new MyMatrix();

        MyMatrix.generateSquareTheMatrix(myMatrix, length);

        System.out.println("Generated matrix ");
        printTheMatrix(myMatrix.getMatrix());

        int result = myMatrix.countAllLocalMinimums();

        List<MyMatrix.Node> minimums = myMatrix.getLocalMinimums();

        System.out.println("Minimums: {row, column, value}");
        for (MyMatrix.Node node : minimums) {
            System.out.println(node);
        }

        System.out.println("Amount of minimums");
        System.out.println(result);

    }

    static void printTheMatrix(int[][] matrix) {
        for (int[] arr : matrix) {
            for (int el : arr) {
                System.out.printf("%5s", el + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
