package view;

import java.util.Scanner;
import model.Student;
import validator.Validator;

public class StudentView {
    private Validator validator;

    public StudentView(Scanner sc) {
        this.validator = new Validator(sc);
    }

    public Student inputStudent() {
        String id = validator.getNonEmptyString("Enter ID: ");
        String name = validator.getValidName("Enter name: ");
        String semester = validator.getValidSemester("Enter semester: ");
        String course = validator.getValidCourse("Enter course (Java/.Net/C/C++): ");
        return new Student(id, name, semester, course);
    }

    public void showMessage(String msg) {
        System.out.println(msg);
    }
}
