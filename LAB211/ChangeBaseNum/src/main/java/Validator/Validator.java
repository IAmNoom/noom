package validator;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    public static int checkNum(String msg, int min, int max) {
        while (true) {
            System.out.print(msg + " ");
            String line = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(line);
                if (v >= min && v <= max) return v;
                System.out.println("Please enter a number between " + min + " and " + max);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter an integer.");
            }
        }
    }

    public static String checkString(String msg) {
        while (true) {
            System.out.print(msg + " ");
            String s = sc.nextLine().trim();
            if (!s.isEmpty()) return s;
            System.out.println("Input cannot be empty.");
        }
    }
}
