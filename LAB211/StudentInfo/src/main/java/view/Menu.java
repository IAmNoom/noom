package view;

import java.util.Scanner;

public class Menu {
    public static int getChoice(String[] options, Scanner sc) {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i+1) + ". " + options[i]);
        }
        System.out.print("You choose: ");
        return Integer.parseInt(sc.nextLine());
    }
}

