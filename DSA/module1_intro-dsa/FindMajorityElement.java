import java.util.Arrays;
import java.util.Scanner;

public class FindMajorityElement {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] arr = new int [n];
        int half = n/2;

        for(int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        Arrays.sort(arr);
        int el = arr[half];
        int count = 1;

        if(half%2 == 0) {
            for(int i = 0; i < half; i++) {
                if(el == arr[i]) {
                    count++;
                }
            }
        }
        else {
            for(int i = 0; i < half; i++) {
                if(el == arr[i]) {
                    count++;
                }
            }
            for(int i = half+1; i < n; i++) {
                if(el == arr[i]) {
                    count++;
                }
            }
        }

        if(count > half){
            System.out.println(el);
        }
    }
}
