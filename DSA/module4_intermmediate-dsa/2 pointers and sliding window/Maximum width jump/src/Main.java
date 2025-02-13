import java.util.*;

class Solution {

    public int solve(int nums[],int n) {
        // Your code here
        int[] maxOnRight = new int[n];
        maxOnRight[n - 1] = nums[n - 1];
        for(int i = n - 2; i >=0; i--) {
            maxOnRight[i] = Math.max(nums[i], maxOnRight[i + 1]);
        }

        int maxWidth = 0;
        int i = 0, j = 1;

        while(j < n) {
            if(nums[i] <= maxOnRight[j]) {
                maxWidth = Math.max(maxWidth, j - i);
                j++;
            } else i++;
        }

        return  maxWidth;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[]=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=sc.nextInt();

        Solution obj=new Solution();
        System.out.println(obj.solve(nums,n));
        sc.close();
    }
}