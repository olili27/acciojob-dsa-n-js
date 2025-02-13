import java.util.*;
import java.lang.*;

class Solution {
    boolean possibleToAllocate(int [] arr, int stds, long capacity) {
        long students = 1;

        long currentPages = 0;

        for (int j : arr) {

            if (currentPages + j <= capacity) {
                currentPages += j;
            } else {
                currentPages = j;
                students++;
            }
        }

        return students <= stds;
    }
    public long MinimumPages(int[] arr, int stds) {
        //Write your code here

        if(arr.length < stds) return -1;

        long lo = arr[0];
        long hi = arr[0];

        for(int i = 1; i < arr.length; i++) {
            lo = Math.max(lo, arr[i]);
            hi += arr[i];
        }

        long possibleAns = -1;

        while(lo <= hi) {
            long mid = (lo + hi) / 2;

            if(possibleToAllocate(arr, stds, mid)) {
                possibleAns = mid;
                hi = mid - 1; // reduce the capacity
            } else {
                lo = mid + 1; // increase the capacity
            }
        }

        return possibleAns;
    }
}

class Main {


    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int B = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++)
            A[i] = sc.nextInt();

        Solution Obj = new Solution();
        System.out.println(Obj.MinimumPages(A,B));
    }
}