package lab1.example1;

public class Main {

    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);

        double eps = 1 / Math.pow(10, k + 1);

        double result = 1;

        double element = 1;

        int grade = 1;

        while (Math.abs(element) >= eps) {
            element = func(x, grade);
            grade++;
            result += element;
        }

        System.out.println("By Taylor's formula:");
        System.out.printf("%." + args[1] + "f\n", result);
        System.out.println("By Math.exp:");
        System.out.printf("%." + args[1] + "f\n", Math.exp(x));

    }

    static double func(double x, int grade) {
        return Math.pow(x, grade) / fact(grade);
    }

    static double fact(int x) {
        if (x == 1) {
            return 1;
        }
        return x * fact(x - 1);
    }
}
