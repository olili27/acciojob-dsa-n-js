public class TwoSum {
    static int [] twoSum(int [] arr, int target) {
        int n = arr.length;

        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                if(arr[i] + arr[j] == target) {
                    return new int [] {arr[i], arr[j]};
                }
            }
        }

        return new int []{};
    }
    public static void main(String[] args) {
        // int [] arr = 
    }
}