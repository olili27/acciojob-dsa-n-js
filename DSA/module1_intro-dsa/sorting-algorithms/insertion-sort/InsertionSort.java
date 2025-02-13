import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int [n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for(int itr = 1; itr <= n-1; itr++) {
            // for(int j = itr; j >= 1; j--) {
            //     if(arr[j] < arr[j-1]) {
            //         int temp = arr[j];
            //         arr[j] = arr[j-1];
            //         arr[j-1] = temp;
            //     }
            // }

            insert(arr, itr);
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int [] insert(int [] arr, int itr) {
        for(int j = itr; j >= 1; j--) {
            if(arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
            }
        }

        return arr;
    }
}
