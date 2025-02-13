import java.util.*;

class Solution {

    public int filling(int gas[],int cost[],int n) {
        //Write your code here
        int gasSum = 0;
        int costSum = 0;

        for (int i = 0; i < n; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum > costSum) return -1;

        int tank = 0;
        int start = -1;

        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            tank += diff;

            if (tank < 0) {
                tank = 0;
                start = -1;
            }
            else if (tank - diff == 0 && start == -1) start = i;
        }

        return start;
    }
}


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        sc.close();
        Solution Obj = new Solution();
        System.out.print(Obj.filling(a,b,n));
    }
}
