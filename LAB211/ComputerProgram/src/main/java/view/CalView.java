package view;

import controller.CalculatorController;

public class CalView extends Menu1 {
    private CalculatorController controller;

    public CalView(String title, String[] options, CalculatorController controller) {
        super(title, options);
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
