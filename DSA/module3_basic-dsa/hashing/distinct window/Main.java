import java.util.*;

public class Main {

    static String smallestSubStr(int n, int k, String s) {

        int start = 0;
        int end = 0;
        int unique = 0;
        int ans = Integer.MAX_VALUE;
        int[] freq = new int[123];
        int ansStart = -1;
        int ansEnd = -1;

        while (end < n) {

            // expansion
            freq[s.charAt(end)]++;

            if (freq[s.charAt(end)] == 1)
                unique++;

            end++;

            // contraction
            while (start < end && unique == k) {
                // calculation
                if (ans > end - start) {
                    ans = end - start;
                    ansStart = start;
                    ansEnd = end;
                }

                freq[s.charAt(start)]--;

                if (freq[s.charAt(start)] == 0)
                    unique--;
                start++;
            }
        }

        if (ansStart == -1)
            return "";
        return s.substring(ansStart, ansEnd);
    }

    public static String DistinctWindow(String s) {
        // write code here
        int n = s.length();
        int[] cnt = new int[123];
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i)]++;
            if (cnt[s.charAt(i)] == 1)
                distinct++;
        }

        return smallestSubStr(n, distinct, s);
    }

    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String ans = DistinctWindow(s);
        System.out.println(ans);
    }
}