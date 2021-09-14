package lab1.example11;

public class Main {
    public static void main(String[] args) {

        double x = Double.parseDouble(args[0]);
        int k = Integer.parseInt(args[1]);

        double eps = 1 / Math.pow(10, k + 1);

        double result = 0;

        double element = x;

        int grade = 1;

        while(Math.abs(element) >= eps) {
            element = func(x, grade);
            grade += 2;
            result += element;
        }

        System.out.println(Math.sinh(x));
        System.out.print(result);

    }

    static double func(double x, int grade) {
        return Math.pow(x, grade) / doubleFact(grade);
    }

    static double doubleFact(int x) {
        if (x == 1) {
            return 1;
        }
        return x * doubleFact(x - 1);
    }
}
