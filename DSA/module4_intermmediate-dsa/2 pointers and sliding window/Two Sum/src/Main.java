import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int[] twoSum(int[] A, int target) {
        // Your code here
        int [] ans = new int [2];

        int l = 0, r = A.length - 1;

        while(l < r) {
            int sum = A[l] + A[r];

            if(sum == target) {
                ans[0] = l + 1;
                ans[1] = r + 1;
                return ans;
            } else if(sum < target) l++;
            else r--;
        }

        return ans;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        int m = Integer.parseInt(br.readLine().trim());
        int[] ans = (twoSum(arr, m));
        System.out.println(ans[0] + " " + ans[1]);
    }
}



