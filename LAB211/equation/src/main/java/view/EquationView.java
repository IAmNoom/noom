package view;

import view.Menu1;
import controller.EquationController;

public class EquationView extends Menu1 {
    private EquationController controller;

    public EquationView(String title, String[] options, EquationController controller) {
        super(title, options);
        this.controller = controller;
    }

    @Override
    public void execute(int n) {
        controller.processSelection(n);
    }

    public void showLines(String... lines) {
        for (String l : lines) System.out.println(l);
    }
}
