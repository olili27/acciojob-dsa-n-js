import java.util.Scanner;

public class BubbleSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int [n];

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int numberOfSwaps = 0;

        for(int itr = 1; itr <= n-1; itr++) {
            boolean isSwapped = false;

            for(int j = 0; j <= n - ( itr + 1); j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;

                    isSwapped = true;
                    numberOfSwaps++;
                }
            }

            if(isSwapped == false) {
                break;
            }
        }

        System.out.print("Array is sorted in ");
        System.out.println(numberOfSwaps + " swaps.");
        System.out.println("First Element: " + arr[0]);
        System.out.println("Last Element: " + arr[n-1]);
    }
}
