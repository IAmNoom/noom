package validation;

import java.util.Scanner;

public class Validation {
    private Scanner sc;

    public Validation(Scanner sc) {
        this.sc = sc;
    }

    public int getPositiveInt(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            try {
                int value = Integer.parseInt(input);
                if (value > 0) return value;
                else System.out.println("⚠ Value must be > 0");
            } catch (NumberFormatException e) {
                System.out.println("⚠ Please enter a valid integer!");
            }
        }
    }

    public double getDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            try {
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Values of matrix must be the number");
            }
        }
    }
}
