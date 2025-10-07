package model;

import java.util.Scanner;

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
        if(!id.matches("\\d{6}")) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Fullname: ");
        fullName = sc.nextLine();
        if(!fullName.matches("[a-zA-Z ]+")) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Phone number: ");
        phone = sc.nextLine();
        if(!phone.matches("\\d{12}")) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Year of birth: ");
        yearOfBirth = Integer.parseInt(sc.nextLine());
        int currentYear = java.time.Year.now().getValue();
        if(yearOfBirth >= currentYear) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Major: ");
        major = sc.nextLine();
        if(major.length() > 30) {
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
