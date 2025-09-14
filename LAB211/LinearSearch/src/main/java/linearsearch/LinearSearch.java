/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package linearsearch;

import java.util.Random;
import java.util.Arrays;

public class LinearSearch {
    private int[] array;

    public LinearSearch(int n) {
        array = new int[n];
    }

    // Sinh mảng ngẫu nhiên từ 0 → scope
    public void generateRandomArray(int scope) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(scope + 1); // 0..scope
        }
    }

    // In mảng ra màn hình
    public void getArray() {
        System.out.println("Array: " + Arrays.toString(array));
    }

    // Tìm kiếm tuyến tính
    public int search(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1; // không tìm thấy
    }
}
