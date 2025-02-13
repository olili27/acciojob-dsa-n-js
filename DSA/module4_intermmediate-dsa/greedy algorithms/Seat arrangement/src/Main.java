import java.util.*;

class Solution {

    public int seat(String s) {
        //Write your code here
        int len = s.length(), count = 0;

        ArrayList<Integer> position = new ArrayList<>();

        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'x') {
                position.add(i - count);
                count++;
            }
        }

        if (count == len || count == 0) return 0;
        int mod = (int) 1e7 + 3;

        int medianIdx = (count - 1) / 2;
        int medianVal = position.get(medianIdx);

        int ans = 0;

        for (int i = 0; i < position.size(); i++) {
            ans = ans % mod + (Math.abs(position.get(i) % mod - medianVal % mod)) % mod;
        }

        return ans % mod;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str= sc.nextLine();
        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.seat(str));
    }
}
