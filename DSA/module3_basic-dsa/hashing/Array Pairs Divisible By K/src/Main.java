import java.io.*;
import java.util.*;

class Solution {
    public boolean arrayPairs(int[] arr, int k) {
        // write code here
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++) {
            int rem = arr[i] % k;
            int freq = hm.getOrDefault(rem, 0);

            hm.put(rem, freq + 1);
        }

        for(int rem: hm.keySet()) {

            if(rem == 0) continue;

            int comp = k - rem;

            if(!hm.containsKey(comp)) return false;

            else if(hm.get(comp) != hm.get(rem)) return false;

        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,k;
        n = sc.nextInt();
        k = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        if(Obj.arrayPairs(arr,k)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}