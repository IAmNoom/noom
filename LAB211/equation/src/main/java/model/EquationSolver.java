package model;

import java.util.ArrayList;
import java.util.List;

public class EquationSolver {

    // Giải phương trình bậc nhất: ax + b = 0
    public static List<Float> calculateEquation(float a, float b) {
        List<Float> res = new ArrayList<>();
        if (a == 0) {
            return (b == 0) ? new ArrayList<>() : null; // [] = vô số nghiệm, null = vô nghiệm
        }
        res.add(-b / a);
        return res;
    }

    // Giải phương trình bậc hai: ax^2 + bx + c = 0
    public static List<Float> calculateQuadraticEquation(float a, float b, float c) {
        List<Float> res = new ArrayList<>();
        if (a == 0) return calculateEquation(b, c);

        float delta = b * b - 4 * a * c;
        if (delta < 0) return null;
        if (delta == 0) {
            res.add(-b / (2 * a));
        } else {
            float s = (float) Math.sqrt(delta);
            res.add((-b + s) / (2 * a));
            res.add((-b - s) / (2 * a));
        }
        return res;
    }

    public static boolean isOdd(float number) {
        int i = (int) number;
        return i % 2 != 0;
    }

    public static boolean isPerfectSquare(float number) {
        if (number < 0) return false;
        double sq = Math.sqrt(number);
        return Math.floor(sq) == sq;
    }
}
