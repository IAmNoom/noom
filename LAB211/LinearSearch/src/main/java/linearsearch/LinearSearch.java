/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package linearsearch;

import java.util.Random;

public class LinearSearch {
    private int[] array;

    // Constructor: khởi tạo mảng với số phần tử n
    public LinearSearch(int n) {
        array = new int[n];
        generateRandomArray();
    }

    // Sinh mảng số ngẫu nhiên trong khoảng 0 -> 10
    private void generateRandomArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(11); // 0 đến 10
        }
    }

    // Getter lấy mảng
    public int[] getArray() {
        return array;
    }

    // Thuật toán tìm kiếm tuyến tính
    public int search(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i; // trả về index đầu tiên tìm thấy
            }
        }
        return -1; // không tìm thấy
    }
}
