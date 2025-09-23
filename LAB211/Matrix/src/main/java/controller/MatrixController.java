package controller;

import validation.Validation;
import model.Matrix;
import view.MatrixView;

import java.util.Scanner;

public class MatrixController {
    private MatrixView view;
    private Validation v;
    private Scanner sc;

    public MatrixController(Scanner sc) {
        this.sc = sc;
        this.v = new Validation(sc);

        String title = "======= Matrix Calculator =======";
        String[] options = {"Addition", "Subtraction", "Multiplication", "Exit"};
        this.view = new MatrixView(title, options, this);
    }

    public void run() {
        view.run();
    }

    public void processSelection(int n) {
        switch (n) {
            case 1: doAddition(); break;
            case 2: doSubtraction(); break;
            case 3: doMultiplication(); break;
            case 4: view.show("Bye!"); break;
        }
    }

    private Matrix inputMatrix(String name) {
        view.show(name + ":");
        int rows = v.getPositiveInt("Enter number of rows: ");
        int cols = v.getPositiveInt("Enter number of columns: ");
        Matrix m = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                double val = v.getDouble("Enter [" + i + "][" + j + "]: ");
                m.setValue(i, j, val);
            }
        }
        return m;
    }

    private void doAddition() {
        view.show("--- Addition ---");
        Matrix m1 = inputMatrix("Matrix 1");
        Matrix m2 = inputMatrix("Matrix 2");
        try {
            Matrix sum = m1.additionMatrix(m2);
            view.show("Result:");
            sum.print();
        } catch (Exception e) {
            view.show("⚠ " + e.getMessage());
        }
    }

    private void doSubtraction() {
        view.show("--- Subtraction ---");
        Matrix m1 = inputMatrix("Matrix 1");
        Matrix m2 = inputMatrix("Matrix 2");
        try {
            Matrix diff = m1.subtractionMatrix(m2);
            view.show("Result:");
            diff.print();
        } catch (Exception e) {
            view.show("⚠ " + e.getMessage());
        }
    }

    private void doMultiplication() {
        view.show("--- Multiplication ---");
        Matrix m1 = inputMatrix("Matrix 1");
        Matrix m2 = inputMatrix("Matrix 2");
        try {
            Matrix prod = m1.multiplicationMatrix(m2);
            view.show("Result:");
            prod.print();
        } catch (Exception e) {
            view.show("⚠ " + e.getMessage());
        }
    }
}
