package controller;

import view.EquationView;
import model.EquationSolver;
import validator.Validator;

import java.util.List;

public class EquationController {
    private EquationView view;

    public EquationController() {
        String title = "========= Equation Program =========";
        String[] options = new String[] {
            "Calculate Linear Equation (ax + b = 0)",
            "Calculate Quadratic Equation (ax^2 + bx + c = 0)",
            "Exit"
        };
        view = new EquationView(title, options, this);
    }

    public void run() {
        view.run();
    }

    public void processSelection(int n) {
        switch (n) {
            case 1:
                view.showLines("----- Linear Equation -----");
                float a = Validator.checkFloat("Enter A:");
                float b = Validator.checkFloat("Enter B:");
                List<Float> res = EquationSolver.calculateEquation(a, b);
                printResult(res);
                showNumberAnalysis(new float[]{a, b});
                break;

            case 2:
                view.showLines("----- Quadratic Equation -----");
                float a1 = Validator.checkFloat("Enter A:");
                float b1 = Validator.checkFloat("Enter B:");
                float c1 = Validator.checkFloat("Enter C:");
                List<Float> res2 = EquationSolver.calculateQuadraticEquation(a1, b1, c1);
                printResult(res2);
                showNumberAnalysis(new float[]{a1, b1, c1});
                break;

            case 3:
                view.showLines("Exiting program...");
                return;
            default:
                view.showLines("Invalid option!");
        }
    }

    private void printResult(List<Float> res) {
        if (res == null) {
            view.showLines("No solution.");
        } else if (res.isEmpty()) {
            view.showLines("Infinitely many solutions.");
        } else if (res.size() == 1) {
            view.showLines(String.format("Solution: x = %.3f", res.get(0)));
        } else {
            view.showLines(String.format("Solution: x1 = %.3f , x2 = %.3f", res.get(0), res.get(1)));
        }
    }

    private void showNumberAnalysis(float[] nums) {
        StringBuilder odd = new StringBuilder();
        StringBuilder even = new StringBuilder();
        StringBuilder square = new StringBuilder();

        for (float f : nums) {
            if (EquationSolver.isOdd(f)) odd.append(f).append(", ");
            else even.append(f).append(", ");
            if (EquationSolver.isPerfectSquare(f)) square.append(f).append(", ");
        }

        if (odd.length() > 0) view.showLines("Odd Number(s): " + odd.toString());
        if (even.length() > 0) view.showLines("Even Number(s): " + even.toString());
        if (square.length() > 0) view.showLines("Perfect Square(s): " + square.toString());
    }
}

