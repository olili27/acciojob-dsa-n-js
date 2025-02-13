import java.io.*;
import java.util.*;

public class Main {

    public static int subarrayDivisbleByK(int arr[], int n, int k){
        // Write code here
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0;
        int count = 0;

        hm.put(sum, 1);

        for(int i = 0; i < n; i++) {
            sum += arr[i];
            int rem = sum % k;

            if(rem < 0) rem = rem + k;

            int freq = hm.getOrDefault(rem, 0);
            count  += freq;
            hm.put(rem, freq + 1);
        }

        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int k=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;++i){
            arr[i]=sc.nextInt();
        }
        int result = subarrayDivisbleByK(arr, n, k);
        System.out.print(result);
        System.out.println('\n');
    }
}