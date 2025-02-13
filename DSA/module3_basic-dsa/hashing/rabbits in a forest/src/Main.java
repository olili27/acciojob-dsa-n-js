import java.util.*;

class Solution{
    public int numRabbits(int[] answers) {
        // write code here
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        int sum = 0;

        for(int element: answers) {
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }

        for(int key: freqMap.keySet()) {
            int groupSize = key + 1;
            int numberOfGroups = freqMap.get(key) / groupSize;

            if(freqMap.get(key) % groupSize > 0) {
                numberOfGroups++;
            }

            sum += numberOfGroups * groupSize;
        }

        return sum;
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
        System.out.println(Obj.numRabbits(arr));
    }
}
