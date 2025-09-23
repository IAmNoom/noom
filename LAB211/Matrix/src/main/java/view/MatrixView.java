package view;

import controller.MatrixController;

import java.util.Scanner;

public class MatrixView extends Menu1 {
    private MatrixController controller;

public MatrixView(String title, String[] options, MatrixController controller) {
    super(title, options);   // gọi constructor không có Scanner
    this.controller = controller;
}


    @Override
    public void execute(int n) {
        controller.processSelection(n);
    }

    public void show(String msg) {
        System.out.println(msg);
    }
}
