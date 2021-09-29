package lab1.example9;

public class Main {
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);

        if (x <= -1 || x > 1) {
            System.out.println("Incorrect entry value");
            System.exit(0);
        }

        double eps = 1 / Math.pow(10, k + 1);

        double result = 0;

        double element = 1;

        int grade = 1;

        while (Math.abs(element) >= eps) {
            element = func(x, grade);
            grade++;
            result += element;
        }


        System.out.println("By Taylor's formula:");
        System.out.printf("%." + args[1] + "f\n", result);
        System.out.println("By Math.log:");
        System.out.printf("%." + args[1] + "f\n", Math.log(1 + x));
    }

    static double func(double x, int grade) {
        return grade % 2 == 0 ? -1 * Math.pow(x, grade) / grade : Math.pow(x, grade) / grade;
    }
}
