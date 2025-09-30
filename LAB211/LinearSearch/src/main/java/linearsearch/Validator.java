package linearsearch;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);

    // Hàm nhập số nguyên dương
    public static int checkNum(String msg) {
        int num;
        while (true) {
            try {
                System.out.print(msg + " ");
                num = Integer.parseInt(sc.nextLine().trim());
                if (num > 0) {
                    return num;
                } else {
                    System.out.println("Please enter a positive integer.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input, please enter a number.");
            }
        }
    }
}

