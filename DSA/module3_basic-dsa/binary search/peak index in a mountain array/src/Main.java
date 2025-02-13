import java.io.*;
import java.util.*;

class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        // Your code here.
        int l = 0, r = arr.length - 1;

        if(arr.length < 3) return -1;

        while(l <= r) {
            int mid = (l + r) / 2;

            if( arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) return mid;
            if(arr[mid - 1] <= arr[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr1[] = new int[n];
        for(int i=0;i<n;i++)
            arr1[i] = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.peakIndexInMountainArray(arr1);
        System.out.print(result + " ");
        System.out.println('\n');
    }
}