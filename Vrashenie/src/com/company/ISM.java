package com.company;


public class ISM {

    public static void main(String[] args) {
        int N = 3;
        double[][] A = new double[3][3];
        A[0][0] = -1;
        A[0][1] = -16;
        A[0][2] = 2;
        A[1][0] = (double) -16;
        A[1][1] = (double) 5;
        A[1][2] = (double) 14;
        A[2][0] = (double) 2;
        A[2][1] = (double) 14;
        A[2][2] = (double) 14;
        double e = (double) 1 / 1000;
        double[] y0 = new double[3];
        for (int i = 0; i < 3; i++)
            y0[i] = 1;
        double[] ynew = new double[3];
        for (int i = 0; i < 3; i++) {
            ynew[i] = 0;
            for (int j = 0; j < 3; j++)
                ynew[i] += A[i][j] * y0[j];
        }
        System.out.println("y0:");
        for (int i = 0; i < 3; i++)
            System.out.println(y0[i]);
        System.out.println("y1:");
        for (int i = 0; i < 3; i++)
            System.out.println(ynew[i]);
        double numerator = 0;
        double denominator = 0;
        for (int i = 0; i < N; i++) {
            numerator += ynew[i] * y0[i];
            denominator += y0[i] * y0[i];
        }
        double l1 = numerator / denominator;
        System.out.println("Лямбда1 = " + l1);
        System.arraycopy(ynew, 0, y0, 0, N);
        int counter = 2;
// int p = counter--;
        double l2;
        while (true) {
            double max = Math.abs(y0[0]);
            for (int i = 1; i < N; i++) {
                if (max < Math.abs(y0[i]))
                    max = Math.abs(y0[i]);
            }
            if (max > 1000) {
                for (int i = 0; i < N; i++)
                    y0[i] /= max;
                System.out.println("y после но�ми�овки:");
                for (int i = 0; i < N; i++)
                    System.out.println(y0[i]);
            }
            for (int i = 0; i < N; i++) {
                ynew[i] = 0;
                for (int j = 0; j < N; j++)
                    ynew[i] += A[i][j] * y0[j];
            }
            System.out.println("y" + counter + ":");
            for (int i = 0; i < N; i++)
                System.out.println(ynew[i]);
            numerator = 0;
            denominator = 0;
            for (int i = 0; i < N; i++) {
                numerator += ynew[i] * y0[i];
                denominator += y0[i] * y0[i];
            }
            l2 = numerator / denominator;
            System.out.println("Лямбда" + counter + " = " + l2);
            System.arraycopy(ynew, 0, y0, 0, N);
            counter++;
            if (Math.abs(l2 - l1) <= e)
                break;
            l1 = l2;

        }
        System.out.println("Собственный векто�:");
        for (int i = 0; i < N; i++)
            System.out.println(ynew[i]);
    }
}
