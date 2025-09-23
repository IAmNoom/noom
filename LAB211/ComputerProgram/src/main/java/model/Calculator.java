package model;

public class Calculator {

    public static double calculate(double a, Operator op, double b) {
        switch (op) {
            case ADD: return a + b;
            case SUB: return a - b;
            case MUL: return a * b;
            case DIV:
                if (b == 0) throw new ArithmeticException("Division by zero!");
                return a / b;
            case POW: return Math.pow(a, b);
            default: throw new IllegalArgumentException("Unsupported operator");
        }
    }

    public static BMIStatus calculateBMI(double weight, double heightCm) {
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        if (bmi < 19) return BMIStatus.UNDER_STANDARD;
        if (bmi < 25) return BMIStatus.STANDARD;
        if (bmi < 30) return BMIStatus.OVERWEIGHT;
        if (bmi < 40) return BMIStatus.FAT;
        return BMIStatus.VERY_FAT;
    }
}
