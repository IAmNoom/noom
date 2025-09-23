package controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            MatrixController controller = new MatrixController(sc);
            controller.run();
        } finally {
            sc.close();
        }
    }
}

