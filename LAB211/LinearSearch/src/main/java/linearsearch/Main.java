/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package linearsearch;

import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập số phần tử mảng
        System.out.print("Enter number of array elements: ");
        int n = sc.nextInt();

        // Khởi tạo LinearSearch với mảng n phần tử ngẫu nhiên
        LinearSearch ls = new LinearSearch(n);

        // Hiển thị mảng
        System.out.println("Generated array: " + Arrays.toString(ls.getArray()));

        // Nhập số cần tìm
        System.out.print("Enter number to search: ");
        int key = sc.nextInt();

        // Tìm kiếm
        int index = ls.search(key);
        if (index != -1) {
            System.out.println("Found " + key + " at index: " + index);
        } else {
            System.out.println(key + " not found in array.");
        }

        sc.close();
    }
}
