package linearsearch;

public class Main {
    public static void main(String[] args) {
        LinearSearch ls = new LinearSearch(Validator.checkNum("Enter the size of array:"));
        ls.generateRandomArray(Validator.checkNum("Enter the scope of the array:"));
        ls.getArray();
/*        int rs = ls.search(Validator.checkNum("Enter the number to be searched:"));
        if (rs >= 0) {
            System.out.println("Element found at index " + rs);
        } else {
            System.out.println("Element not found");
        }
*/
        ls.bubbleSort();
//        ls.quickSort();
        int rs = ls.binarySearch(Validator.checkNum("Enter the number to be searched:"));
        if (rs >= 0) {
            System.out.println("Element found at index " + rs);
        } else {
            System.out.println("Element not found");
        }
        ls.getArray();
    }
}
