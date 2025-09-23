package shapes;

import java.util.Scanner;

public class Validation {
    private Scanner sc;

    public Validation(Scanner sc) {
        this.sc = sc;
    }

    // kiểm tra nhập số thực > 0
    public double getPositiveDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            try {
                double value = Double.parseDouble(input);
                if (value > 0) {
                    return value;
                } else {
                    System.out.println("⚠ Value must be > 0. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid number. Try again.");
            }
        }
    }

    // nhập cạnh tam giác, đảm bảo tam giác hợp lệ
    public double[] getTriangleSides() {
        while (true) {
            double a = getPositiveDouble("Please input side A of Triangle: ");
            double b = getPositiveDouble("Please input side B of Triangle: ");
            double c = getPositiveDouble("Please input side C of Triangle: ");

            if (a + b > c && a + c > b && b + c > a) {
                return new double[]{a, b, c};
            } else {
                System.out.println("⚠ Invalid triangle. Sum of two sides must be greater than the remaining side.");
            }
        }
    }
}
