import java.io.*;
import java.util.*;

class Solution
{
    static int solve(int n, int[] arr, int k) {
        // Write your code here
        HashMap<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);

        int ans = 0;
        int cSum = 0;
        for (int i = 0; i < n; i++) {
            cSum += arr[i];

            int prevSum = cSum - k;
            if (mp.containsKey(prevSum)) {
                ans += mp.get(prevSum);
            }

            mp.put(cSum, mp.getOrDefault(cSum, 0) + 1);
        }

        return ans;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();


        // S

        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scn.nextInt();

        int k = scn.nextInt();

        System.out.println(Solution.solve(n, arr, k));
    }
}