import java.util.*;
import java.lang.*;
import java.io.*;

class Main {


    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[(int)n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        System.out.println(new Solution().maximumArea(arr, n));
    }
}

class Solution
{
    static long [] pse(long [] arr, int n) {

        Stack<Integer> stack = new Stack<>();
        long ans [] = new long [n];

        for(int i = n - 1; i >= 0; i-- ) {
            while(!stack.empty() && arr[i] < arr[stack.peek()]) {
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

    static long [] nse(long [] arr, int n) {
        Stack<Integer> stack = new Stack<>();
        long ans [] = new long [n];

        for(int i = 0; i < n; i++ ) {
            while(!stack.empty() && arr[i] < arr[stack.peek()]) {
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
    public static long maximumArea(long hist[], long n){
        //Your code here
        long [] l = pse(hist, (int)n);
        long [] r = nse(hist, (int)n);

        long maxArea = 0;

        for(int i = 0; i < (int)n; i++) {
            long area = hist[i] * (r[i] - l[i] - 1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;

    }
}



