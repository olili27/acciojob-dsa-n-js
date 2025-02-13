import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int q = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] queries = new int[q][2];
        for (int i = 0; i < q; i++) {
            for (int j = 0; j < 2; j++) {
                queries[i][j] = sc.nextInt();
            }
        }

        int[] result = Solution.xorQueries(arr, queries);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
    class Solution{
        static void build(int [] pref, int [] arr) {
            for(int i = 0; i < arr.length; i++) {
                pref[i] = arr[i] ^ (i - 1>= 0 ? pref[i - 1]  : 0);
            }
        }

        static int xorRange(int [] pref, int sp, int ep) {
            if(sp == 0) return pref[ep];

            return pref[ep] ^ pref[sp - 1];
        }

        public static int[] xorQueries(int[] A, int[][] queries) {
            // your code goes here
            int [] ans = new int [queries.length];
            int [] pref = new int [A.length];

            build(pref, A);

            for(int i = 0; i < queries.length; i++) {
                int sp = queries[i][0];
                int ep = queries[i][1];

                ans[i] = xorRange(pref, sp, ep);
            }

            return  ans;
        }
    }


