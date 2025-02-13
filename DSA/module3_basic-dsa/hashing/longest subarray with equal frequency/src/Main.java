import java.util.*;

class Solution{
    public static int longestSubarray(int[] arr){
        // write code here
        int n = arr.length;
        int ones = 0, zeros = 0, twos = 0;
        int maxLen = 0;

        HashMap<String, Integer> hm = new HashMap<>();
        hm.put("0#0", -1);

        for(int i = 0; i < n; i++) {

            if(arr[i] == 0) zeros++;
            else if(arr[i] == 1) ones++;
            else twos++;

            int d10 = ones - zeros;
            int d21 = twos - ones;
            String code = d10 + "#" + d21;

            if(hm.containsKey(code)) {
                int len = i - hm.get(code);
                maxLen = Math.max(maxLen, len);
            } else {
                hm.put(code, i);
            }
        }

        return maxLen;
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
        Solution Obj =  new Solution();
        System.out.println(Obj.longestSubarray(arr));
    }
}
