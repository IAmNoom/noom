package view;

import view.Menu1;
import controller.BaseController;

public class BaseView extends Menu1 {
    private BaseController controller;

    public BaseView(String title, String[] options, BaseController controller) {
        super(title, options);
        this.controller = controller;
    }

    @Override
    public void execute(int n) {
        controller.processSelection(n);
    }

    public void showResult(String result) {
        System.out.println("Result: " + result);
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
