package validator;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public static float checkFloat(String msg) {
        while (true) {
            System.out.print(msg + " ");
            String line = sc.nextLine().trim();
            try {
                return Float.parseFloat(line);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number!");
            }
        }
    }
}
