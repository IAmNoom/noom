package model;

import java.util.Scanner;

public class Teacher extends Person {
    private int yearInProfession;
    private String contractType;
    private double salaryCoefficient;

    public Teacher() {
        super();
        yearInProfession = 0;
        contractType = "";
        salaryCoefficient = 0;
    }

    @Override
    public void inputAll(Scanner sc) {
        super.inputAll(sc);
        System.out.print("Year in the profession: ");
        yearInProfession = Integer.parseInt(sc.nextLine());
        if(yearInProfession < 0 || yearInProfession >= (java.time.Year.now().getValue() - yearOfBirth)) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Contract type: ");
        contractType = sc.nextLine();
        if(!contractType.equalsIgnoreCase("Long") && !contractType.equalsIgnoreCase("Short")) {
            System.out.println("Data input is invalid");
            return;
        }

        System.out.print("Salary coefficient: ");
        salaryCoefficient = Double.parseDouble(sc.nextLine());
        if(salaryCoefficient < 0) {
            System.out.println("Data input is invalid");
        }
    }

    public int getYearInProfession() { return yearInProfession; }

    @Override
    public void print() {
        super.print();
        System.out.printf(" | %-2d | %-5s | %.1f\n", yearInProfession, contractType, salaryCoefficient);
    }
}

