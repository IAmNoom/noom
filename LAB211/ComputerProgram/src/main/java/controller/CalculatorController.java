package controller;

import validator.Validator;
import model.Calculator;
import model.Operator;
import model.BMIStatus;
import view.CalView;

public class CalculatorController {
    private CalView view;

    public CalculatorController() {
        String title = "========= Calculator Program =========";
        String[] options = {"Normal Calculator", "BMI Calculator", "Exit"};
        view = new CalView(title, options, this);
    }

    public void run() {
        view.run();
    }

    public void processSelection(int n) {
        switch (n) {
            case 1:
                normalCalculator();
                break;
            case 2:
                bmiCalculator();
                break;
            case 3:
                view.show("Exiting program...");
                break;
        }
    }

    private void normalCalculator() {
        view.show("----- Normal Calculator -----");
        double memory = Validator.checkNumber("Enter number:");
        while (true) {
            String opStr = Validator.checkOperator("Enter Operator:");
            Operator op = Operator.fromString(opStr);
            if (op == Operator.EQUAL) {
                view.show("Result: " + memory);
                break;
            }
            double b = Validator.checkNumber("Enter number:");
            try {
                memory = Calculator.calculate(memory, op, b);
                view.show("Memory: " + memory);
            } catch (ArithmeticException e) {
                view.show("⚠ Error: " + e.getMessage());
            }
        }
    }

    private void bmiCalculator() {
        view.show("----- BMI Calculator -----");
        double weight = Validator.checkNumber("Enter Weight(kg):");
        double height = Validator.checkNumber("Enter Height(cm):");
        double heightM = height / 100.0;
        double bmi = weight / (heightM * heightM);
        BMIStatus status = Calculator.calculateBMI(weight, height);
        view.show(String.format("BMI Number: %.2f", bmi));
        view.show("BMI Status: " + status);
    }
}

