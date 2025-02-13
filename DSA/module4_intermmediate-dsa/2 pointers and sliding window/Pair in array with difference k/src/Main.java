import java.util.*;
class Main{
    public static void main (String[] args) {
        Scanner sc=new Scanner(System.in);
        int n,k;
        n=sc.nextInt();
        k=sc.nextInt();
        int[] a= new int[n];
        for(int i=0;i<n;i++){
            a[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.findPairs(a,n,k));
    }
}

class Solution
{
    public int findPairs(int[] nums,int n, int k) {
        //Write code here
        Arrays.sort(nums);

        int l = 0, r = 1;
        int count = 0;

        while(r < n) {
            int diff = nums[r] - nums[l];

            if(diff == k) {
                count++;
                l++;
                while(l < r && nums[l] == nums[l - 1]) l++;

                r++;
                while(r < n && nums[r] == nums[r - 1]) r++;
            }
            else if(diff > k) {
                l++;
                while(l < r && nums[l] == nums[l - 1]) l++;
            } else {
                r++;
                while(r < n && nums[r] == nums[r - 1]) r++;
            }

            if(l == r) r++;
        }

        return count;
    }
}