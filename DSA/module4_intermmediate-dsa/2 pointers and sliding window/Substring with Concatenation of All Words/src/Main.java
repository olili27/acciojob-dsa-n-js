import java.util.*;

class Solution {

    boolean excessWords(HashMap<String, Integer> ideal, HashMap<String, Integer> hm) {
        for(String s: hm.keySet()) {
            if(!ideal.containsKey(s)) return true;

            if(hm.get(s) > ideal.get(s)) return true;
        }

        return false;
    }
    public List<Integer> findSubstring(String s, String[] words) {
        // write code here
        List<Integer> ans = new ArrayList<>();

        int noOfWords = words.length;
        int wordLength = words[0].length();
        int strLength = s.length();

        HashMap<String, Integer> ideal = new HashMap<>();
        for(String str: words) ideal.put(str, ideal.getOrDefault(str, 0) + 1);

        for(int i = 0; i < wordLength; i++) {
            int sp = i, ep = i;
            HashMap<String, Integer> hm = new HashMap<>();

            while(ep + wordLength <= strLength) {
                String current = s.substring(ep, ep + wordLength);
                hm.put(current, hm.getOrDefault(current, 0) + 1);
                ep += wordLength;

                while(sp < ep && excessWords(ideal, hm)) {
                    String toBeDeleted = s.substring(sp, sp + wordLength);
                    hm.put(toBeDeleted, hm.get(toBeDeleted) - 1);

                    if(hm.get(toBeDeleted) == 0) hm.remove(toBeDeleted);
                    sp += wordLength;
                }

                if(noOfWords * wordLength == ep - sp) ans.add(sp);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String str = scn.next();
        int n = scn.nextInt();
        String[] words = new String[n];
        for(int i=0;i<n;i++){
            words[i] = scn.next();
        }
        Solution Obj =  new Solution();
        List<Integer> indexes = Obj.findSubstring(str,words);
        Collections.sort(indexes);
        for(int i=0;i<indexes.size();i++){
            System.out.print(indexes.get(i) + " ");
        }
        System.out.println();
    }
}
