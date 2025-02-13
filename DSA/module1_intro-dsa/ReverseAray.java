import java.util.Arrays;
import java.util.Collections;

// import java.util.Scanner;

class ReverseArray{
    public static void main(String[] args) {
        // Scanner s = new Scanner(System.in);
        Integer[] arr ={1,2,3,4,5};

//       int i = 0;
       int n = arr.length;
       int j = n - 1;

//        while(i<j) {
//         int temp = arr[i];
//         arr[i] = arr[j];
//         arr[j] = temp;
//         i++;
//         j--;
//        }

        for (int i = 0; i < n / 2; i++) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;

            j--;
        }

        System.out.println(Arrays.toString(arr));

    }
}