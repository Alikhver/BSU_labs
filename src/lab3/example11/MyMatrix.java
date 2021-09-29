package lab3.example11;

import java.util.ArrayList;
import java.util.List;

public class MyMatrix {

    private int[][] matrix;

    private List<Node> localMinimums;

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public static void generateSquareTheMatrix(MyMatrix param, int length) {

        int[][] matrix = new int[length][length];
        param.setMatrix(matrix);

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                matrix[i][j] = (int) Math.floor(Math.random() * 2 * length - length + 1);
            }
        }
    }

    public int countAllLocalMinimums() {
        localMinimums = new ArrayList<>();
        int[][] matrix = this.getMatrix();
        int amount = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (isLocalMinimum(matrix, i, j)) {
                    amount++;
                    localMinimums.add(new Node(i, j, matrix[i][j]));
                }
            }
        }
        System.out.println();
        return amount;
    }

    private static boolean isLocalMinimum(int[][] matrix, int i, int j) {
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

        return true;
    }

    public List<Node> getLocalMinimums() {
        return localMinimums;
    }

    static class Node {

        public Node(int i, int j, int value) {
            this.i = i;
            this.j = j;
            this.value = value;
        }

        private int i;
        private int j;
        private int value;

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "{" + i + ", " + j + ", " + value + "}";
        }
    }
}
