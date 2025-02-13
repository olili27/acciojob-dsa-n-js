import java.util.*;



class Main {

    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = input.nextInt();
        }
        Solution solution = new Solution();
        List<List<Integer>> result = solution.threeSum(nums);
        //Sort all lists inside the list first
        for (int i = 0; i < result.size(); i++) {
            Collections.sort(result.get(i));
        }
        //Sort the list
        Collections.sort(result, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> l1, List<Integer> l2) {
                for (int i = 0; i < l1.size(); i++) {
                    if (l1.get(i) < l2.get(i)) return -1;
                    else if (l1.get(i) > l2.get(i)) return 1;
                }
                return 0;
            }
        });
        for (int i = 0; i < result.size(); i++) {
            for (int j = 0; j < result.get(i).size(); j++) {
                System.out.print(result.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
}

class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++) {
            int newTarget = - nums[i];

            int l = i + 1, r = nums.length - 1;

            while(l < r) {
                int sum = nums[l] + nums[r];

                if(sum == newTarget) {
                    List<Integer> currentList = new ArrayList<>();
                    currentList.add(nums[i]);
                    currentList.add(nums[l]);
                    currentList.add(nums[r]);

                    ans.add(currentList);

                    l++;
                    while(l < r && nums[l] == nums[l - 1]) l++;

                    r--;
                    while(r > l && nums[r] == nums[r + 1]) r--;
                }
                else if(sum > newTarget) {
                    r--;
                    while (r > l && nums[r] == nums[r + 1]) r--;
                }
                else {
                    l++;
                    while(l < r && nums[l] == nums[l - 1]) l++;
                }
            }

            while(i + 1 < nums.length && nums[1 + 1] == nums[i]) i++;
        }

        return ans;
    }
}