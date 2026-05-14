package lab12;

public class calculator {

    private double add(double a, double b) {
        return a + b;
    }

    private double subtract(double a, double b) {
        return a - b;
    }

    private double multiply(double a, double b) {
        return a * b;
    }

    private double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Тэгд хуваах боломжгүй!");
        }
        return a / b;
    }

    public double calculate(double a, double b, String operator) {
        switch (operator) {
            case "+": return add(a, b);
            case "-": return subtract(a, b);
            case "*": return multiply(a, b);
            case "/": return divide(a, b);
            default:  throw new IllegalArgumentException("Буруу үйлдэл: " + operator);
        }
    }
}