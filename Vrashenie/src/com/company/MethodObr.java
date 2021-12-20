package com.company;

public class MethodObr {

    public static void main(String[] args) {
        double[][]a = new double[2][2];
        a[0][0] = (double)6;
        a[0][1] = (double)2;
        a[1][0] = (double)2;
        a[1][1] = (double)8;
        boolean flag = false;
        double y1 = 1;
        double y2 = 0;
        double y1next = 0;
        double y2next = 0;
        int k = 0;
        double Lk = 0, Lkplusone = 0;
        double eps = (double)1/1000;
        int choise = 0;
        double E = 1;
        if (choise == 0)
        {
            while (flag == false)
            {
                k++;
                y1next = (a[1][1] * y1 - a[0][1] * y2) / (a[1][1] * a[0][0] - a[0][1] * a[1][0]);
                y2next = (a[0][0] * y2 - a[1][0] * y1) / (a[1][1] * a[0][0] - a[0][1] * a[1][0]);

                System.out.print("k: ");
                System.out.println(k);
                System.out.print("y1: ");
                System.out.println(y1next);
                System.out.print("y2: ");
                System.out.println(y2next);

                Lkplusone = ((y1 * y1 + y2 * y2) / (y1next * y1 + y2next * y2));

                if (Math.abs(Lkplusone - Lk) < eps)
                    flag = true;

                y1 = y1next;
                y2 = y2next;

                if (k == 5 || k == 10 || k == 15)
                {
                    if (Math.abs(y1) > Math.abs(y2))
                    {
                        y2 = y2 / y1;
                        y1 = 1;
                    }
                    else
                    {
                        y1 = y1 / y2;
                        y2 = 1;
                    }

                    System.out.print("y1: ");
                    System.out.println(y1);
                    System.out.print("y2: ");
                    System.out.println(y2);
                }

                System.out.print("L: ");
                System.out.println(Lkplusone);
                Lk = Lkplusone;
            }
        }
        else
        {
            k++;

            y1next = ((a[1][1] - E) * y1 - a[0][1] * y2) / ((a[1][1] - E) * (a[0][0] - E) - a[0][1] * a[1][0]);
            y2next = ((a[0][0] - E) * y2 - a[1][0] * y1) / ((a[1][1] - E) * (a[0][0] - E) - a[0][1] * a[1][0]);

            System.out.print("k: ");
            System.out.println(k);
            System.out.print("y1: ");
            System.out.println(y1next);
            System.out.print("y2: ");
            System.out.println(y2next);

            Lkplusone = E + ((y1 * y1 + y2 * y2) / (y1next * y1 + y2next * y2));

            if (Math.abs(Lkplusone - Lk) < eps) {
                flag = true;
            }

            Lk = Lkplusone;

            y1 = y1next;
            y2 = y2next;

            System.out.print("L: ");
            System.out.println(Lkplusone);

            if (k == 5 || k == 10 || k == 15) {
                if (Math.abs(y1) > Math.abs(y2)) {
                    y2 = y2 / y1;
                    y1 = 1;
                }
                else {
                    y1 = y1 / y2;
                    y2 = 1;
                }

                System.out.print("y1: ");
                System.out.println(y1);
                System.out.print("y2: ");
                System.out.println(y2);

            }

            System.out.println("--------------------------------------");
            System.out.println();
        }
    }
}




