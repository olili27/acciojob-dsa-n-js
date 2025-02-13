import java.io.*;
import java.util.*;

class Solution {

    boolean isSatisfied(int [] sfreq, int [] tfreq) {
        for(int i = 0; i < 123; i++) {
            if(sfreq[i] < tfreq[i]) return false;
        }

        return true;
    }
    public String minWindow(String s, String t) {
        // write code here
        int s_len = s.length(), t_len = t.length();
        int start = 0, end = 0;
        int answer = Integer.MAX_VALUE;
        int subStart = -1, subEnd = -1;

        // freq array for chars in t
        int t_freq [] = new int [123];

        for(int i = 0; i < t_len; i++) {
            t_freq[t.charAt(i)]++;
        }

        // freq array for chars in s
        int s_freq [] = new int [123];

        while(end < s_len) {

            // expand
            s_freq[s.charAt(end)]++;
            end++;

            // contract
            while(start < end && isSatisfied(s_freq, t_freq)) {
                // calculate
                if(answer > end -  start) {
                    answer = end - start;
                    subStart = start;
                    subEnd = end;
                }

                s_freq[s.charAt(start)]--;
                start++;
            }
        }

        if(subStart == -1) return "";

        return s.substring(subStart, subEnd);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s,t;
        s = sc.next();
        t = sc.next();
        Solution Obj = new Solution();
        System.out.print(Obj.minWindow(s,t));
    }
}