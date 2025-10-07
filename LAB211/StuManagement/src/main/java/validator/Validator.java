package validator;

import java.util.Scanner;

public class Validator {
    private Scanner sc;

    public Validator(Scanner sc) {
        this.sc = sc;
    }

    // Nhập chuỗi không rỗng
    public String getNonEmptyString(String msg) {
        while (true) {
            System.out.print(msg);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("⚠ Value cannot be empty!");
        }
    }

    // Nhập tên hợp lệ (chỉ chữ và khoảng trắng)
    public String getValidName(String msg) {
        while (true) {
            String name = getNonEmptyString(msg);
            if (name.matches("[a-zA-Z ]+")) {
                return name;
            }
            System.out.println("⚠ Name must contain only letters and spaces!");
        }
    }

    // Nhập số nguyên dương
    public String getValidSemester(String msg) {
        while (true) {
            String sem = getNonEmptyString(msg);
            if (sem.matches("\\d+")) {
                return sem;
            }
            System.out.println("⚠ Semester must be a positive integer!");
        }
    }

    // Nhập course hợp lệ
    public String getValidCourse(String msg) {
        while (true) {
            String course = getNonEmptyString(msg);
            if (course.equalsIgnoreCase("Java")
                    || course.equalsIgnoreCase(".Net")
                    || course.equalsIgnoreCase("C")
                    || course.equalsIgnoreCase("C++")){
                return course;
            }
            System.out.println("⚠ Course must be Java / .Net / C/C++");
        }
    }
}
