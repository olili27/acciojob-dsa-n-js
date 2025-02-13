public class FindLargestInArray {
    public static void main(String[] args) {
        int arr [] = {1, 4, 50, 9, 17, 6, 20};
        int idx = largest(0, arr);
        System.out.println(idx);
    }

    static int largest(int idx, int arr []) {
        if(idx == arr.length) {
            return 0;
        }

        int smallSolution = largest(idx + 1, arr);
        
        int ans = Math.max(arr[idx], smallSolution);
        // if(smallSolution > arr[idx]) {
        //     ans = smallSolution;
        // }
        // else {
        //     ans = arr[idx];
        // }
        return ans;
    }
}
