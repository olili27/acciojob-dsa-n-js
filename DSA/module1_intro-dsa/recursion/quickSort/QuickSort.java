package quickSort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 8, 3, 19, 3, 39, 2, 1, 22, 11 };
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int arr[], int start, int end) {
        if (start < end) {
            int pivotIndex = partition(arr, start, end);
            quickSort(arr, start, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, end);
        }
    }

    static int partition(int arr[], int start, int end) {
        int pivot = arr[start];

        int i = start, j = end;

        while (i < j) {
            while (i <= end && arr[i] <= pivot) {

                i++;
            }

            while (j >= 0 && arr[j] > pivot) {
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[start] = arr[j];
        arr[j] = pivot;
        return j;
    }
}
