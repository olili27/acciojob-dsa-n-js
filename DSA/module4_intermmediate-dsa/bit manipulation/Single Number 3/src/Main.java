import java.util.*;

class Solution {

    public int[] singleNumber3(int n, int[] nums) {
        // write code here
        int xorArray = 0;
        for (int num: nums) xorArray ^= num;

        int k = 0;
        while ((xorArray & 1 << k) == 0) k++; // get the rightmost set bit

        int kthBitSet = 0;
        int kthBitUnset = 0;

        for (int num: nums) {
            if ((num & 1 << k) > 0) kthBitSet ^= num;
            else kthBitUnset ^= num;
        }

        int [] ans = {kthBitSet, kthBitUnset};
        Arrays.sort(ans);

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scn.nextInt();
        }
        Solution Obj = new Solution();
        scn.close();
        int[] ans = Obj.singleNumber3(n, arr);
        System.out.print(ans[0] + " " + ans[1]);
    }
}