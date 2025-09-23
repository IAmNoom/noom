package view;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Menu1 {
    protected String title;
    protected ArrayList<String> mChon;

    public Menu1() {}
    public Menu1(String td, String[] mc) {
        title = td;
        mChon = new ArrayList<>();
        for (String s : mc) mChon.add(s);
    }

    public void display() {
        System.out.println(title);
        System.out.println("--------------------------------");
        for (int i = 0; i < mChon.size(); i++) {
            System.out.println((i + 1) + ". " + mChon.get(i));
        }
        System.out.println("--------------------------------");
    }

    public int getSelected() {
        Scanner sc = new Scanner(System.in);
        int choice;
        while (true) {
            display();
            System.out.print("Please choice one option: ");
            String input = sc.nextLine().trim();
            try {
                choice = Integer.parseInt(input);
                if (choice >= 1 && choice <= mChon.size()) {
                    return choice;
                } else {
                    System.out.println("⚠ Please enter a number between 1 and " + mChon.size());
                }
            } catch (NumberFormatException e) {
                System.out.println("⚠ Invalid input. Please enter a number!");
            }
        }
    }

    public abstract void execute(int n);

    public void run() {
        while (true) {
            int n = getSelected();
            execute(n);
            if (n == mChon.size()) break;
        }
    }
}
