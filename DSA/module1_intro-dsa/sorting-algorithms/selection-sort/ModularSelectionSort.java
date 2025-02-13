import java.util.Arrays;

public class ModularSelectionSort {
    public static void main(String[] args) {
        int arr [] = {3, 7, 9, 25, 40, 1, 5, 17, 8};
        selectionSort(arr);
    }

    static void selectionSort(int arr []) {
        int n = arr.length;

        for(int itr = 1; itr <= n - 1; itr++) {
            int maxIndex = findIndexForLargest(itr, arr);

            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n - itr];
            arr[n - itr] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    static int findIndexForLargest(int itr, int [] arr) {
        int n = arr.length;
        int maxIndex = 0;

        for(int i = 1; i <= n - itr; i++) {
            if(arr[i] > arr[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
