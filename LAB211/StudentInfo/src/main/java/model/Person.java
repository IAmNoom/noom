package model;

import java.util.Scanner;
import validator.Validator;

public class Person {
    protected String id, fullName, phone, major;
    protected int yearOfBirth;

    public Person() {
        id = fullName = phone = major = "";
        yearOfBirth = 0;
    }

public void inputAll(Scanner sc) {
    System.out.print("ID: ");
    id = sc.nextLine();
    if (!Validator.isValidID(id)) {
        System.out.println("Data input is invalid");
        return;
    }

    System.out.print("Fullname: ");
    fullName = sc.nextLine();
    if (!Validator.isValidFullName(fullName)) {
        System.out.println("Data input is invalid");
        return;
    }

    System.out.print("Phone number: ");
    phone = sc.nextLine();
    if (!Validator.isValidPhone(phone)) {
        System.out.println("Data input is invalid");
        return;
    }

    System.out.print("Year of birth: ");
    yearOfBirth = Integer.parseInt(sc.nextLine());
    if (!Validator.isValidYearOfBirth(yearOfBirth)) {
        System.out.println("Data input is invalid");
        return;
    }

    System.out.print("Major: ");
    major = sc.nextLine();
    if (!Validator.isValidMajor(major)) {
        System.out.println("Data input is invalid");
    }
}

    public String getFullName() { return fullName; }
    public int getYearOfBirth() { return yearOfBirth; }

    public void print() {
        System.out.printf("%-6s | %-20s | %-12s | %-4d | %-20s", 
            id, fullName, phone, yearOfBirth, major);
    }
}
