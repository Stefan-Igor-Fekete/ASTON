package calculations;

public class FactorialCalculation {
    public static long factorial(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("Число не должно быть отрицательным");
        }
        if (n > 20) {
            throw new ArithmeticException("Нельзя высчитать факториал числа > 20 из-за ограничений типа long");
        }
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}