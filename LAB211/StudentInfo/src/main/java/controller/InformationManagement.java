package controller;

import model.*;
import view.Menu;
import java.util.*;

public class InformationManagement {
    private static ArrayList<Teacher> teachers = new ArrayList<>();
    private static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mainMenu = {"Teacher", "Student", "Person", "Exit"};
        int choice;
        do {
            System.out.println("*** Information Management ***");
            choice = Menu.getChoice(mainMenu, sc);
            switch (choice) {
                case 1 -> teacherMenu(sc);
                case 2 -> studentMenu(sc);
                case 3 -> personMenu(sc);
                case 4 -> System.out.println("BYE AND SEE YOU NEXT TIME");
            }
        } while (choice != 4);
    }

    private static void teacherMenu(Scanner sc) {
        String[] menu = {"Input", "Print", "Exit"};
        int c;
        do {
            System.out.println("*** Teacher Management ***");
            c = Menu.getChoice(menu, sc);
            switch (c) {
                case 1 -> {
                    Teacher t = new Teacher();
                    t.inputAll(sc);
                    teachers.add(t);
                }
                case 2 -> {
                    teachers.sort((a,b)->b.getYearInProfession()-a.getYearInProfession());
                    System.out.println("# - ID - Fullname - Phone - Birth - Major - YearProf - Contract - Salary");
                    int i = 1;
                    for (Teacher t : teachers) {
                        System.out.print(i++ + " - ");
                        t.print();
                    }
                }
            }
        } while (c != 3);
    }

    private static void studentMenu(Scanner sc) {
        String[] menu = {"Input", "Print", "Exit"};
        int c;
        do {
            System.out.println("*** Student Management ***");
            c = Menu.getChoice(menu, sc);
            switch (c) {
                case 1 -> {
                    Student s = new Student();
                    s.inputAll(sc);
                    students.add(s);
                }
                case 2 -> {
                    students.sort(Comparator.comparingInt(Student::getYearOfAdmission));
                    System.out.println("# - ID - Fullname - Phone - Birth - Major - Admission - Score");
                    int i = 1;
                    for (Student s : students) {
                        System.out.print(i++ + " - ");
                        s.print();
                    }
                }
            }
        } while (c != 3);
    }

    private static void personMenu(Scanner sc) {
        String[] menu = {"Search", "Print all", "Exit"};
        int c;
        do {
            System.out.println("*** Person Management ***");
            c = Menu.getChoice(menu, sc);
            switch (c) {
                case 1 -> {
                    System.out.print("Name: ");
                    String name = sc.nextLine().toLowerCase();
                    ArrayList<Person> list = new ArrayList<>();
                    list.addAll(teachers);
                    list.addAll(students);
                    boolean found = false;
                    for (Person p : list) {
                        if (p.getFullName().toLowerCase().contains(name)) {
                            System.out.println("Result:");
                            System.out.println("# - ID - Fullname - Phone - Birth - Major");
                            p.print();
                            System.out.println();
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Result: not found");
                }
                case 2 -> {
                    System.out.println("# - ID - Fullname - Phone - Birth - Major");
                    ArrayList<Person> list = new ArrayList<>();
                    list.addAll(teachers);
                    list.addAll(students);
                    list.sort((a,b)->b.getYearOfBirth()-a.getYearOfBirth());
                    int i = 1;
                    for (Person p : list) {
                        System.out.print(i++ + " - ");
                        p.print();
                        System.out.println();
                    }
                }
            }
        } while (c != 3);
    }
}

