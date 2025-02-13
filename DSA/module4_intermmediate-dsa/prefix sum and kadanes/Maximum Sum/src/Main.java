import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    public static int maximumSum(int[] arr, int[][] ops) {
        int [] freq = new int [arr.length];

        for(int i = 0; i < ops.length; i++) {
            int sp = ops[i][0];
            int ep = ops[i][1];

            freq[sp]++;

            if(ep + 1 < arr.length) freq[ep + 1]--;
        }

        // create a prefix sum array
        for(int i = 1; i < freq.length; i++) {
            freq[i] += freq[i - 1];
        }

        Arrays.sort(freq);
        Arrays.sort(arr);

        int score = 0;
        int mod = (int) 1e9 + 7;

        for(int i = 0; i < arr.length; i++) {
            score = ((score % mod) + ((freq[i] % mod) * (arr[i] % mod)) % mod) % mod;
        }

        return score;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        int[] arr = new int[(int)n];
        for(int i=0; i<n; i++)arr[i]=Integer.parseInt(inputLine[i]);
        long m = Long.parseLong(br.readLine().trim());
        int[][] ops = new int[(int)m][2];
        for(int i=0; i<m; i++){
            String inputLine1[] = br.readLine().trim().split(" ");
            ops[i][0]=Integer.parseInt(inputLine1[0]);
            ops[i][1]=Integer.parseInt(inputLine1[1]);
        }
        System.out.println(maximumSum(arr, ops));
    }
}







