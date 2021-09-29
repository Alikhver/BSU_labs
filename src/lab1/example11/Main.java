package lab1.example11;

public class Main {

    public static void main(String[] args) {

        double x = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);

        double eps = 1 / Math.pow(10, k + 1);

        double result = 0;

        double element = x;

        double prev = 1;

        int grade = 1;

        while (Math.abs(element) >= eps) {
            element = func(x, prev, grade);
            grade += 2;
            result += element;
            prev = element;
        }

        System.out.println("By Taylor's formula:");
        System.out.printf("%." + args[1] + "f\n", result);
        System.out.println("By Math.sinh:");
        System.out.printf("%." + args[1] + "f\n", Math.sinh(x));

    }

    static double func(double x, double prev, int grade) {
        if (grade == 1) {
            return x;
        } else {
            return prev * Math.pow(x, 2) / grade / (grade -1);
        }
    }

}
