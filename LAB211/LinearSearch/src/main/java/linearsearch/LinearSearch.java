package linearsearch;

import java.util.Random;
import java.util.Arrays;

public class LinearSearch {
    private int[] array;
    private int key;

    public LinearSearch(int n) {
        array = new int[n];
    }

    public void generateRandomArray(int scope) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(scope + 1); 
        }
    }

    public void getArray() {
        System.out.println("Array: " + Arrays.toString(array));
    }

    public int search(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                return i;
            }
        }
        return -1;
    }
    
    public void bubbleSort(){
        boolean check = false;
        for (int i = 0; i < array.length-1; i++){
            for (int j = 0; j < array.length - i - 1; j++){
                if (array[j]> array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    check = true;
                }
            }
            if (!check) break;
        }
    }
    
    public void quickSort() {
        quickSort(0, array.length - 1);
    }

    private void quickSort(int left, int right) {
        if (left < right) {
            int pivotIndex = partition(left, right);
            quickSort(left, pivotIndex - 1);
            quickSort(pivotIndex + 1, right);
        }
    }

    private int partition(int left, int right) {
        int mid = left + (right - left) / 2;
        int pivot = array[mid];
        swap(mid, right);
        
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j] <= pivot) {
                i++;
                swap(i, j);
            }
        }
        swap(i + 1, right);
        return i + 1;
    }

    private void swap(int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    
    public void binarySearch(){
        binarySearch(key);
    }


    public int binarySearch(int x) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == x) {
                return mid; // tìm thấy
            }
            if (array[mid] < x) {
                left = mid + 1; // tìm bên phải
            } else {
                right = mid - 1; // tìm bên trái
            }
        }
        return -1; // không tìm thấy
    }
}
