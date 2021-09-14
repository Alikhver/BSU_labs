package lab1.example1;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
//        double x;
//        int k;
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        x = Double.parseDouble(reader.readLine());
//        k = Integer.parseInt(reader.readLine());
        double x = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);

//        reader.close();

        double eps = Math.pow(10, k + 1);

        double result = 1;

        double element = 1;

        int grade = 1;

        while(Math.abs(element) >= 1 / eps) {
            element = func(x, grade);
            grade++;
            result += element;
        }

        System.out.println(Math.exp(x));
        System.out.print(result);

    }

    static double func(double x, int grade) {
        return Math.pow(x, grade) / fact(grade);
    }

    static double fact(int x) {
        if (x == 1) {
            return 1;
        }
        return x * fact(x-1);
    }
}
