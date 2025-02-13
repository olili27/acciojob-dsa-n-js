import java.util.*;
import java.io.*;
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        // Write your code here
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                int l = j + 1, r = nums.length - 1;

                int newTarget = target - (nums[i] + nums[j]);

                while(l < r) {
                    int sum = nums[l] + nums[r];

                    if(sum == newTarget) {
                        List<Integer> currentList = new ArrayList<>();
                        currentList.add(nums[i]);
                        currentList.add(nums[j]);
                        currentList.add(nums[l]);
                        currentList.add(nums[r]);

                        ans.add(currentList);

                        l++;
                        while(l < r && nums[l] == nums[l - 1]) l++;

                        r--;
                        while(r > l && nums[r] == nums[r + 1]) r--;
                    } else if(sum > newTarget) {
                        r--;
                        while (r > l && nums[r] == nums[r + 1]) r--;
                    }
                    else {
                        l++;
                        while(l < r && nums[l] == nums[l - 1]) l++;
                    }
                }

                while(j + 1 < nums.length && nums[j] == nums[j + 1]) j++;
            }

            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }

        return ans;
    }
}

public class Main
{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        int k = sc.nextInt();
        Solution Obj = new Solution();
        List<List<Integer>> res = Obj.fourSum(nums, k);


        for(int i= 0; i<res.size(); i++){
            Collections.sort(res.get(i));
        }


        Collections.sort(res, new Comparator<List<Integer>>() {
            public int compare(List<Integer> frst, List<Integer> scnd) {
                int i=0;
                while(frst.get(i)==scnd.get(i)) i++;
                return frst.get(i)-scnd.get(i);
            }
        });

        for(int i=0; i<res.size(); i++){
            for(int j=0; j<4; j++){
                System.out.print(res.get(i).get(j) + " ");
            }
            System.out.println("");
        }
        sc.close();
    }
}