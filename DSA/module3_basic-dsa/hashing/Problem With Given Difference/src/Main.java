import java.io.*;
import java.util.*;

class Solution {
    public int givenDifference(int []arr, int n, int k) {
        // write your code here
        Map <Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(hm.containsKey(arr[i] + k) || hm.containsKey(arr[i] - k))
                return 1;
            int oldVal = hm.getOrDefault(arr[i], 0);
            hm.put(arr[i], oldVal + 1);
        }
        return 0;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n,B;
        n = sc.nextInt();
        int []mat=new int[n];
        for(int i=0;i<n;++i){
            mat[i]=sc.nextInt();
        }
        B = sc.nextInt();
        Solution Obj = new Solution();
        System.out.println(Obj.givenDifference(mat,n,B));
        System.out.println('\n');
    }
}
