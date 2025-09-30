package stack;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyStack stack = new MyStack();

        while (true) {
            System.out.println("===== STACK MENU =====");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Get top value");
            System.out.println("4. Display stack");
            System.out.println("5. Exit");
            System.out.print("Choose: ");

            String choice = sc.nextLine().trim();
            switch (choice) {
                case "1":
                    System.out.print("Enter value to push: ");
                    int val = Integer.parseInt(sc.nextLine().trim());
                    stack.push(val);
                    break;
                case "2":
                    stack.pop();
                    break;
                case "3":
                    stack.get();
                    break;
                case "4":
                    stack.display();
                    break;
                case "5":
                    System.out.println("Bye!");
                    sc.close();
                    return;
                default:
                    System.out.println("⚠ Invalid choice!");
            }
        }
    }
}

