import java.util.*;
import java.lang.*;
import java.io.*;

class Solution {
    public void merge(int[][] intervals) {
        // Your code here, Print your output here
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int n = intervals.length;

        int prevStart = intervals[0][0];
        int prevEnd = intervals[0][1];

        for(int i = 0; i < n; i++) {
            int currStart = intervals[i][0];
            int currEnd = intervals[i][1];

            if(currStart <= prevEnd) {
                prevEnd = Math.max(prevEnd, currEnd);
                // System.out.println(prevStart + " " + prevEnd);
            } else {
                System.out.println(prevStart + " " + prevEnd);
                prevStart = currStart;
                prevEnd = currEnd;
            }
        }

        System.out.println(prevStart + " " + prevEnd);

    }
}

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int m;
        m = sc.nextInt();
        int[][] A = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                A[i][j] = sc.nextInt();
            }
        }
        Solution Obj = new Solution();
        Obj.merge(A);

    }
}