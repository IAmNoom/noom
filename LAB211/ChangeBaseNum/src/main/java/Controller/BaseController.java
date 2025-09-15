package controller;

import view.BaseView;
import model.BaseConverter;
import validator.Validator;

public class BaseController {
    private BaseView view;

    public BaseController() {
        String title = "========= Base Number Converter =========";
        String[] options = new String[] {"Binary", "Decimal", "Hexadecimal", "Exit"};
        view = new BaseView(title, options, this);
    }

    public void run() {
        view.run();
    }

    public void processSelection(int n) {
        // n: 1=Binary,2=Decimal,3=Hex,4=Exit
        if (n == 4) {
            view.showMessage("Exiting program...");
            return;
        }

        int outChoice = Validator.checkNum("Choose output base (1-3):", 1, 3);
        String inputVal = Validator.checkString("Enter value:");

        int inBase = (n == 1) ? 2 : (n == 2) ? 10 : 16;
        int outBase = (outChoice == 1) ? 2 : (outChoice == 2) ? 10 : 16;

        try {
            String result = BaseConverter.convert(inputVal, inBase, outBase);
            view.showResult(result);
        } catch (IllegalArgumentException ex) {
            view.showMessage("Invalid input: " + ex.getMessage());
        } catch (Exception ex) {
            view.showMessage("Error: " + ex.getMessage());
        }
    }
}
