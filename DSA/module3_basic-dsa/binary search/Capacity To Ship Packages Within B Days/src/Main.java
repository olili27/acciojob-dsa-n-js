import java.util.*;
import java.lang.*;

class Solution{

    static boolean isPossible(int [] arr, int maxDays, long capacity) {
        long days = 1;
        long currentPackages = 0;

        for(int i: arr) {

            if(currentPackages + i <= capacity) {
                currentPackages += i;
            } else {
                days++;
                currentPackages = i;
            }
        }

        return days <= maxDays;
    }
    public static long solve(int[] A, int B) {
        //Write your code here
        long lo = A[0];
        long hi = A[0];

        for(int i = 1; i < A.length; i++) {
            lo = Math.max(lo, A[i]);
            hi += A[i];
        }

        long answer = -1;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;
            if(isPossible(A, B, mid)) {
                answer = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }

        return answer;
    }
}

class Main {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        for(int i=0;i<n;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        System.out.println(Solution.solve(A,B));
    }
}