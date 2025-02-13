import java.util.*;

class Main {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++){
            a[i] = input.nextInt();
        }
        Solution ob =new Solution();
        long ans = ob.maxSubarraySum(a,n);
        System.out.println(ans);
    }
}
class Solution{

    long kadanes(int [] arr) {
        long maxSum = Integer.MIN_VALUE;
        long currTrain = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            long startNewTrain = arr[i];
            long goWithOldTrain = currTrain + arr[i];

            currTrain = Math.max(startNewTrain, goWithOldTrain);
            maxSum = Math.max(currTrain, maxSum);
        }

        return maxSum;
    }

    public long maxSubarraySum(int a[],int n){
        //Write code here
        return kadanes(a);
    }
}