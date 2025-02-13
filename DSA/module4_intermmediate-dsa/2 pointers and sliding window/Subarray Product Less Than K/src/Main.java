import java.util.*;

class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        //Write code here
        int windowProduct = 1;
        int sp = 0, ep = 0;
        int ans = 0;

        while(ep < nums.length) {
            windowProduct *= nums[ep];

            while(windowProduct >= k) {
                windowProduct /= nums[sp];
                sp++;
            }

            ans += (ep - sp + 1);
            ep++;
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int k;
        k = sc.nextInt();
        Solution Obj = new Solution();
        int result = Obj.numSubarrayProductLessThanK(arr, k);
        System.out.println(result);
        sc.close();
    }
}