import java.util.*;
import java.lang.*;
import java.io.*;

class Solution
{
    public static long[] nextLargerElement(long[] arr, int n)
    {
        //Write code here and print output
        Stack <Integer> stack = new Stack<>();
        long [] ans = new long [n];

        for(int i = 0; i < n; i++) {
            while(stack.size() > 0 && arr[i] > arr[stack.peek()]) {

                // insert the index of the nge at the index of the element in inspection
                ans[stack.peek()] = arr[i];
                stack.pop();
            }

            stack.push(i);
        }

        while(stack.size() > 0) {
            ans[stack.peek()] = -1;
            stack.pop();
        }

        return ans;
    }
}
class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        String inputLine[] = br.readLine().trim().split(" ");
        long[] arr = new long[n];
        for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
        long[] res = new Solution().nextLargerElement(arr, n);
        for (int i = 0; i < n; i++)
            System.out.print(res[i] + " ");
        System.out.println();
    }
}