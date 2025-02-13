import java.util.*;

class Solution{

    static boolean possibleToPlace(int [] arr, int cows, int minDistance) {
        int cowsPlaced = 1;
        int lastPositionPlacedAt = arr[0];

        for(int i = 1; i < arr.length; i++) {
            if(arr[i] - lastPositionPlacedAt >= minDistance) {
                cowsPlaced++;
                lastPositionPlacedAt = arr[i];
            }
        }

        return cowsPlaced >= cows;
    }

    public static int aggressiveCows(int [] arr, int cows){
        //Write your code here
        Arrays.sort(arr);

        int lo = 1;
        int hi = arr[arr.length - 1] - arr[0];

        int minDistanceThatIsMax = 0;

        while(lo <= hi) {
            int mid = (lo + hi) / 2;

            if(possibleToPlace(arr, cows, mid)) {
                minDistanceThatIsMax = mid;
                lo = mid + 1; // increase the minDistance
            } else hi = mid -1; // reduce min minDistance
        }

        return minDistanceThatIsMax;
    }


}

class Main {
    public static void main(String [] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++)
        {
            nums[i] = sc.nextInt();
        }
        Solution obj=new Solution();
        System.out.println(obj.aggressiveCows(nums,k));

    }
}
