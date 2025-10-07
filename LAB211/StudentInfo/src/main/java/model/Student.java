package model;

import java.util.Scanner;

public class Student extends Person {
    private int yearOfAdmission;
    private int englishScore;

    public Student() {
        super();
        yearOfAdmission = 0;
        englishScore = 0;
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        System.out.print("Year of admission: ");
        yearOfAdmission = Integer.parseInt(sc.nextLine());
        int currentYear = java.time.Year.now().getValue();
        if(yearOfAdmission < yearOfBirth || yearOfAdmission > currentYear) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Entrance English score: ");
        englishScore = Integer.parseInt(sc.nextLine());
        if(englishScore < 0 || englishScore > 100) {
            System.out.println("Data input is invalid");
        }
    }

    public int getYearOfAdmission() { return yearOfAdmission; }

    @Override
    public void print() {
        super.print();
        System.out.printf(" | %-4d | %-3d\n", yearOfAdmission, englishScore);
    }
}
