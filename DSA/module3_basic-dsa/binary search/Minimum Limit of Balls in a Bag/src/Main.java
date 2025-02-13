import java.util.*;
class Solution
{

    static boolean isPossible(int [] arr, int maxOp, int limit) {
        int numberOfOps = 0;

        for(int currentBall: arr) {
            int dividers = currentBall / limit;

            if( currentBall % limit == 0) dividers--;

            numberOfOps += dividers;
        }

        return numberOfOps <= maxOp;
    }
    public static int solve(int n,int op,int [] arr)
    {
        // Write your code here
        int lo = 1;
        int hi = 0;

        for(int ball: arr) {
            hi = Math.max(hi, ball);
        }

        int answer = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(isPossible( arr, op, mid)) {
                answer = mid;
                hi = mid - 1;
            } else lo = mid + 1;
        }

        return answer;
    }
}
public class Main {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt(), m = input.nextInt();
        int[] arr;
        arr= new int[n];
        for(int i = 0; i < n; i++)arr[i]=input.nextInt();
        System.out.println(Solution.solve(n,m,arr));
    }
}