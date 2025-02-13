import java.util.HashMap;
import java.io.*;
import java.util.*;

class Solution {
    public int maxLen(int arr[])
    {
        // Write your code here
        Map<Integer, Integer> hm = new HashMap<>(); // (sum, index)
        int n = arr.length;
        int sum = 0;
        int maxLen = 0;

        hm.put(sum, -1); // initial values for the hashmap

        for(int i = 0; i < n; i++) {
            sum += arr[i];

            if(hm.containsKey(sum)) {
                int len = i - hm.get(sum);
                maxLen = Math.max(len, maxLen);
            } else {
                hm.put(sum, i);
            }
        }
        return maxLen;

    }
}

class Main {

    public static void main(String arg[])
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxLen(nums));
    }
}
