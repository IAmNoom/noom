package shapes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Validation v = new Validation(sc);

        System.out.println("=====Calculator Shape Program=====");

        // Nhập dữ liệu hình chữ nhật
        double width = v.getPositiveDouble("Please input side width of Rectangle: ");
        double length = v.getPositiveDouble("Please input length of Rectangle: ");

        // Nhập dữ liệu hình tròn
        double radius = v.getPositiveDouble("Please input radius of Circle: ");

        // Nhập dữ liệu hình tam giác (đảm bảo hợp lệ)
        double[] sides = v.getTriangleSides();
        double a = sides[0], b = sides[1], c = sides[2];

        // Tạo các đối tượng
        Shape rectangle = new Rectangle(width, length);
        Shape circle = new Circle(radius);
        Shape triangle = new Triangle(a, b, c);

        // In kết quả
        rectangle.printResult();
        circle.printResult();
        triangle.printResult();

        sc.close();
    }
}

