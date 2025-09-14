/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.charcount;

import java.util.Scanner;

public class Validator {
    private static final Scanner sc = new Scanner(System.in);
    public static String checkString(String msg) {
        String input;
        while (true) {
            System.out.print(msg + " ");
            input = sc.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("⚠ Input cannot be empty. Please enter again.");
                continue;
            }
            if (!input.matches("[a-zA-Z0-9 ]+")) {
                System.out.println("⚠ Input contains invalid characters! Only letters, digits and spaces are allowed.");
                continue;
            }
            return input;
        }
    }
}

