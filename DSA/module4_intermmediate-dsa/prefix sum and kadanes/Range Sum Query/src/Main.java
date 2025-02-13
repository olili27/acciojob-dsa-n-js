import java.util.*;

class Solution {

    void build(int [] pref, int [] arr) {
        pref[0] = arr[0];

        for(int i = 1; i < arr.length; i++) {
            pref[i] = arr[i] + pref[i - 1];
        }
    }
    int rangeSum(int [] pref, int sp, int ep) {
        if(sp == 0) return pref[ep];

        return pref[ep] - pref[sp - 1];
    }
    public int[] sumQuery(int[] arr, int[][] ranges) {
        // Your code here.
        int n = arr.length;
        int r = ranges.length;

        int [] pref = new int [n];
        build(pref, arr);

        int [] ans = new int [r];

        for(int query = 0; query < r; query++) {
            int sp = ranges[query][0];
            int ep = ranges[query][1];

            ans[query] = rangeSum(pref, sp, ep);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int m;
        m = sc.nextInt();
        int[][] ranges = new int[m][2];
        for(int i = 0; i < m; i++) {
            ranges[i][0] = sc.nextInt();
            ranges[i][1] = sc.nextInt();
        }
        Solution Obj = new Solution();
        int[] ans = Obj.sumQuery(arr, ranges);
        for(int i =0; i< ans.length; i++)
            System.out.print(ans[i] + " ");
    }
}