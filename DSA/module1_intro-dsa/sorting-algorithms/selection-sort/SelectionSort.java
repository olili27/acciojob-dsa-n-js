import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        for (int itr = 1; itr <= n - 1; itr++) {
            // int maxIndex = 0;

            // for (int j = 0; j <= n - itr; j++) {
            //     if (arr[j] > arr[maxIndex]) {
            //         maxIndex = j;
            //         int temp = arr[maxIndex];
            //         arr[maxIndex] = arr[n - itr];
            //         arr[n - itr] = temp;
            //     }
            // }

            int maxIndex = select(arr, itr);

            int temp = arr[maxIndex];
            arr[maxIndex] = arr[n - itr];
            arr[n - itr] = temp;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static int select(int [] arr, int itr) {
    int n = arr.length;
    int maxIndex = 0;

    for(int j = 0; j <= n - itr; j++) {
    if(arr[j] > arr[maxIndex]) {
    maxIndex = j;
    }
    }
    return maxIndex;
    }
}
