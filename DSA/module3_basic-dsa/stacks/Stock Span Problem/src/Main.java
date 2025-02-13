import java.io.*;
import java.util.*;

class Pair{
    int val;
    int idx;
    Pair(int val, int idx){
        this.val = val;
        this.idx = idx;
    }
}

public class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = input.nextInt();
        }
        Solution s  = new Solution();
        int ans[] = s.stockSpan(a);
        for(int i = 0; i < n; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

class Solution {

    static int [] pge(int [] arr, int n) {
        int [] ans = new int [n];
        Stack <Integer> stack = new Stack<>();

        for(int i = n - 1; i >=0; i--) {

            while(!stack.empty() && arr[i] > arr[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while(!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }

        return ans;
    }

    static int[] stockSpan(int[] a) {
        int n = a.length;
        int [] pge = pge(a, n);
        int [] ans = new int [n];

        for(int i = 0; i < n; i++) {
            int breakpoint = pge[i];
            int cnt = i - breakpoint;

            ans[i] = cnt;
        }

        return ans;
    }
}