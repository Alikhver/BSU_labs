package com.company;

public class Vra2 {
    public static void main(String args[]) {
        double[][]A = new double[3][3];
        A[0][0] = (double)-1;
        A[0][1] = (double)-16;
        A[0][2] = (double)2;
        A[1][0] = (double)-16;
        A[1][1] = (double)5;
        A[1][2] = (double)14;
        A[2][0] = (double)2;
        A[2][1] = (double)14;
        A[2][2] = (double)14;
        double coef = 9;

        int l = 0, m = 0;
        double tempDouble = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                {
                    if (Math.abs(A[i][j]) > tempDouble)
                    {
                        l = i;
                        m = j;
                        tempDouble = Math.abs(A[i][j]);
                    }
                }
            }
        }
        System.out.println("Максимальный элемент в мат�ице А(0) = " + tempDouble + " с коо�динатами l = " + l + ", m = " + m);
        double [][] u = new double[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                    u[i][j] = 0;
                else
                    u[i][j] = 1;
            }
        }

        double fi = 0.5 * Math.atan((2 * A[l][m]) / (A[l][l] - A[m][m]));
        System.out.println("Угол фи в мат�ице А = " + fi);

        u[l][l] = Math.cos(fi);
        System.out.println("Cos phi = " + u[l][l]);

        u[l][m] = -1 * Math.sin(fi);

        u[m][l] = Math.sin(fi);
        System.out.println("sin phi = " + u[m][l]);

        u[m][m] = Math.cos(fi);

        System.out.println("Мат�ица U0:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                System.out.print(u[i][j] + " ");
            System.out.println();
        }

        double[][] ut = new double[3][3];
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                ut[i][j] = u[j][i];
        }

        double[][]one = new double[3][3];
        System.out.println("Результат умножения Ut на A0:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                one[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    one[i][j] += ut[i][z] * A[z][j];
                System.out.print(one[i][j] + " ");
            }
            System.out.println();
        }
        double [][]two = new double[3][3];
        System.out.println("Мат�ица А1:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                two[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    two[i][j] += one[i][z] * u[z][j];
                System.out.print(two[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                A[i][j] = two[i][j];
        }

//пошла вто�ая ите�ация


        l = 0;
        m = 0;
        tempDouble = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                {
                    if (Math.abs(A[i][j]) > tempDouble)
                    {
                        l = i;
                        m = j;
                        tempDouble = Math.abs(A[i][j]);
                    }
                }
            }
        }
        System.out.println("Максимальный элемент в мат�ице А(1) = " + tempDouble + " с коо�динатами l = " + l + ", m = " + m);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                    u[i][j] = 0;
                else
                    u[i][j] = 1;
            }
        }
        fi = 0.5 * Math.atan((2 * A[l][m]) / (A[l][l] - A[m][m]));
        System.out.println("Угол фи в мат�ице А1 = " + fi);

        u[l][l] = Math.cos(fi);
        System.out.println("Cos phi = " + u[l][l]);

        u[l][m] = -1 * Math.sin(fi);

        u[m][l] = Math.sin(fi);
        System.out.println("sin phi = " + u[m][l]);

        u[m][m] = Math.cos(fi);

        System.out.println("Мат�ица U1:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                System.out.print(u[i][j] + " ");
            System.out.println();
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                ut[i][j] = u[j][i];
        }

        System.out.println("Результат умножения Ut на A1:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                one[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    one[i][j] += ut[i][z] * A[z][j];
                System.out.print(one[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Мат�ица А2:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                two[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    two[i][j] += one[i][z] * u[z][j];
                System.out.print(two[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < 3; i++)
        {
            System.arraycopy(two[i], 0, A[i], 0, 3);
        }

//т�етья ите�ация

        l = 0;
        m = 0;
        tempDouble = 0;
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                {
                    if (Math.abs(A[i][j]) > tempDouble)
                    {
                        l = i;
                        m = j;
                        tempDouble = Math.abs(A[i][j]);
                    }
                }
            }
        }
        System.out.println("Максимальный элемент в мат�ице А(2) = " + tempDouble + " с коо�динатами l = " + l + ", m = " + m);
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                if (i != j)
                    u[i][j] = 0;
                else
                    u[i][j] = 1;
            }
        }
        fi = 0.5 * Math.atan((2 * A[l][m]) / (A[l][l] - A[m][m]));
        System.out.println("Угол фи в мат�ице А2 = " + fi);

        u[l][l] = Math.cos(fi);
        System.out.println("Cos phi = " + u[l][l]);

        u[l][m] = -1 * Math.sin(fi);

        u[m][l] = Math.sin(fi);
        System.out.println("sin phi = " + u[m][l]);

        u[m][m] = Math.cos(fi);

        System.out.println("Мат�ица U2:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                System.out.print(u[i][j] + " ");
            System.out.println();
        }
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                ut[i][j] = u[j][i];
        }

        System.out.println("Результат умножения Ut на A2:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                one[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    one[i][j] += ut[i][z] * A[z][j];
                System.out.print(one[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Мат�ица А3:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                two[i][j] = 0;
                for (int z = 0; z < 3; z++)
                    two[i][j] += one[i][z] * u[z][j];
                System.out.print(two[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i < 3; i++)
            two[i][i] /= coef;
        System.out.println("Мат�ица после умножения/деления на коэффициент:");
        for (int i = 0; i < 3; i++)
        {
            for (int j = 0; j < 3; j++)
                System.out.print(two[i][j] + " ");
            System.out.println();
        }
    }
}