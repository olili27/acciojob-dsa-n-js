import java.util.*;

public class Main {

    public static int longestkSubstr(int n, int k,String s){
        //write code here
        int start  = 0, end = 0;
        int ans = -1, unique = 0;

        int [] freq = new int [123]; // 'a' -> 'z' [97 - 122]

        while(end < n) {

            // expansion
            freq[s.charAt(end)]++;
            if(freq[s.charAt(end)] == 1) unique++;
            end++;

            // contraction
            while(start < end && unique > k) {
                freq[s.charAt(start)]--;
                if(freq[s.charAt(start)] == 0) unique--;
                start++;
            }

            // calculation
            if(unique == k) ans = Math.max(ans, end - start);
        }

        return ans;
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();
        int ans = longestkSubstr(n,k,s);
        System.out.println(ans);
    }
}