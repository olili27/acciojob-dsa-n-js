public class TwoSum2 {
    static int [] sum(int [] arr, int target) {
        int i = 0;
        int j = arr.length -1;

        while(i < j) {
            if(arr[i] + arr[j] > target) {
                j--;
            } else if(arr[i] + arr[j] < target) {
                i++;
            } else {
                return new int [] {i, j};
            }
        }

        return new int []{};
    }
}
