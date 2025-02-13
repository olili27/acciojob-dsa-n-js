import java.io.*;
import java.util.*;

class Solution{

    int [] nsr(int n, int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int ans [] = new int [n];
        
        for(int i = 0; i < n; i++) {
            while(!stack.empty() && arr[i] <= arr[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while(!stack.empty()) {
            ans[stack.peek()] = n;
            stack.pop();
        }

        return ans;
    }

    int[] nsl(int n, int arr[]) {
        Stack<Integer> stack = new Stack<>();
        int ans[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.empty() && arr[i] < arr[stack.peek()]) {
                ans[stack.peek()] = i;
                stack.pop();
            }

            stack.push(i);
        }

        while (!stack.empty()) {
            ans[stack.peek()] = -1;
            stack.pop();
        }

        return ans;
    }

	public long minSubarraySum(int n, int arr[]){
		// write code here
        int [] nsl = nsl(n, arr);
        int [] nsr = nsr(n, arr);

        long sum = 0;
        long mod = 1000000007;

        for(int i = 0; i < n; i++) {
            long noOfSubArrays = (long)(nsr[i] - i) * (long)(i - nsl[i]);
            long temp = ((noOfSubArrays % mod) * (arr[i] % mod)) % mod;
            sum = (sum % mod + temp % mod) % mod;
        }

        return sum;
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
		Solution Obj = new Solution();
        System.out.println(Obj.minSubarraySum(n,a));
    }
}