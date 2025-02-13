import java.util.Arrays;

public class MdularInsertionSort {
    public static void main(String[] args) {
        int arr [] = {3, 7, 1, 28, 5, 11, 15};
        insertionSort(arr);
    }

    static void insertionSort(int arr []) {
        int n = arr.length;

        for(int itr = 1; itr <= n - 1; itr++) {
            insert(itr, arr);
        }
        System.out.println(Arrays.toString(arr));
    }

    static void insert(int itr, int [] arr) {
        for(int i = itr; i >= 1; i--) {
            if(arr[i] > arr[i -1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            }
        }
    }
}
