import java.util.*;
import java.lang.*;
//import java.io.*;

class Main {
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0;i<N;i++){
            A[i] = sc.nextInt();
        }
        int B = sc.nextInt();
        Solution ob = new Solution();
        System.out.println(ob.search(A,B));

    }
}

class Solution{

    int findIndexForMinimum(int [] arr) {
        int l = 0, r = arr.length - 1;

        if(arr[l] < arr[r]) return l;

        while(l <= r) {
            int mid = (l + r) / 2;

            if(arr[mid + 1] < arr[mid]) return mid + 1;
            if(arr[mid - 1] > arr[mid]) return mid;
            if(arr[l] <= arr[mid]) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }

    int binarySearch(int[] array, int low, int high, int target) {

        while(low <= high) {
            int mid = (low + high) /2;

            if(array[mid] > target) high = mid - 1;
            else if(array[mid] < target) low = mid + 1;
            else {
                return mid;
            }

        }

        return -1;
    }
    public int search(final int[] arr, int target) {
        //Write code here
        if(arr[0] == target) return 0;
        int minIndex = findIndexForMinimum(arr);
        int l = 0, r = arr.length - 1;

        if(arr[minIndex] == target) {
            return minIndex;
        } else if(target > arr[r]){
            r = minIndex - 1;
            return binarySearch(arr, l, r, target);
        }
        return binarySearch(arr, minIndex + 1, r, target);
    }
}