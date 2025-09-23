package validator;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public static Double checkNumber(String msg) {
        while (true) {
            System.out.print(msg + " ");
            String line = sc.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid number. Try again.");
            }
        }
    }

    public static String checkOperator(String msg) {
        while (true) {
            System.out.print(msg + " ");
            String op = sc.nextLine().trim();
            if (op.matches("[+\\-*/^=]")) {
                return op;
            }
            System.out.println("⚠ Please input one of (+, -, *, /, ^, =)");
        }
    }
}


