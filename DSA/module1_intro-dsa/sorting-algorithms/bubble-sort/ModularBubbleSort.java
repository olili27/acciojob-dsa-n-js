import java.util.Arrays;

class ModularBubbleSort {
    public static void main(String[] args) {
        int arr [] = {32, 19, 11, 9, 8, 4, 1};
        bubbleSOrt(arr);
    }

    static void bubbleSOrt(int [] arr) {
        int n = arr.length;

        boolean isSwapped = false;

        for(int itr = 1; itr <= n - 1; itr++) {
            findLargerAndSwap(isSwapped, itr, arr);

            if(isSwapped == false) {
                System.out.println("no swapping");
                break;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    static void findLargerAndSwap(boolean isSwapped, int itr, int [] arr) {
        int n = arr.length;
        
        for(int j = 0; j <= n - (itr + 1); j++) {
            int k = j + 1;

            if(arr[j] < arr[k]) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
                isSwapped = true;
            }
        }
    }
}