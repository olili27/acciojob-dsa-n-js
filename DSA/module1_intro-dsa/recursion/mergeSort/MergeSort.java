import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int arr [] = {1,5,2,9,11,7,23,20,4,14};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr)); 
    }

    static void mergeSort(int arr [], int start, int end) {
        if(start < end) { // to make sure there are at least 2 elements in the array
            int mid = (start + end) / 2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }

    static void merge(int arr [], int start, int mid, int end) {

        // build a temporary array to avoid modifying the original array/its contents
        int [] temp = new int [end - start + 1];
        int i = start, j = mid + 1;
        int k =0; // to keep track of the elements inserted into the temp

        while(i <= mid && j <= end) {
            if(arr[i] < arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        // if values for i still exist
        while(i <= mid) {
            temp[k++] = arr[i++];
        }

         // if values for j still exist
         while(j <= end) {
            temp[k++] = arr[j++];
        }

        // to fill the subarray with sorted elements
        for(int x = start; x <= end; x++) {
            arr[x] = temp[x - start];
        }
    }
}
