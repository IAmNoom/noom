package controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String title = "WELCOME TO STUDENT MANAGEMENT";
        String[] options = {
            "Create",
            "Find and Sort",
            "Update/Delete",
            "Report",
            "Exit"
        };

        StudentController menu = new StudentController(title, options, sc);
        menu.run();

        sc.close();
    }
}

