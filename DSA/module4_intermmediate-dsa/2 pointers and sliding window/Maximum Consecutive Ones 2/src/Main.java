import java.util.*;

class Solution {
    static int maxOne(int arr[], int n,int k)
    {
        //Write your code here
        int numberOfZeroesInCurrentWindow = 0;
        int sp = 0, ep = 0;
        int ans = 0;

        while(ep < arr.length) {
            // check for zero -> expansion
            if(arr[ep] == 0) numberOfZeroesInCurrentWindow++;

            // ensure current window has utmost k zeroes -> contraction
            while(numberOfZeroesInCurrentWindow > k) {
                if(arr[sp] == 0) numberOfZeroesInCurrentWindow--;
                sp++;
            }

            // calculation
            ans = Math.max(ans, ep - sp + 1);
            ep++;
        }

        return ans;
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int k= sc.nextInt();
        int array[] = new int[n];

        for(int i=0; i<n; i++){
            array[i]= sc.nextInt();
        }
        Solution Obj = new Solution();
        System.out.println(Obj.maxOne(array,n,k));
    }
}