import java.util.*;

class Solution {
    public int MaxSum(int[] arr, int n) {
        // Write your code here
        int wholeArraySum = 0;

        int maxSubarraySum = -100000;
        int currMax = maxSubarraySum;

        int minSubarraySum = 100000;
        int currMin = minSubarraySum;

        for(int i = 0; i < n; i++) {
            wholeArraySum += arr[i];

            int startNewMax = arr[i];
            int addToOldMax = currMax + arr[i];
            currMax = Math.max(addToOldMax, startNewMax);
            maxSubarraySum = Math.max(currMax, maxSubarraySum);

            int startNewMin = arr[i];
            int addToOldMin = currMin + arr[i];
            currMin = Math.min(startNewMin, addToOldMin);
            minSubarraySum = Math.min(currMin, minSubarraySum);
        }

        if(wholeArraySum == minSubarraySum) return maxSubarraySum;

        return Math.max(maxSubarraySum, wholeArraySum - minSubarraySum);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        Solution Obj = new Solution();
        int ans = Obj.MaxSum(arr, n);
        System.out.println(ans);
    }
}